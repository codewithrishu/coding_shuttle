package com.example.springbootMVCWeek2.springbootMVCWeek2.services;


import com.example.springbootMVCWeek2.springbootMVCWeek2.dto.EmployeeDTO;
import com.example.springbootMVCWeek2.springbootMVCWeek2.entities.EmployeeEntity;
import com.example.springbootMVCWeek2.springbootMVCWeek2.exceptions.ResourceNotFoundException;
import com.example.springbootMVCWeek2.springbootMVCWeek2.repositories.EmployeeRepository;
import org.apache.el.util.ReflectionUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeByID(Long id) {

       return employeeRepository.findById(id)
               .map(employeeEntity1 -> modelMapper.map(employeeEntity1,EmployeeDTO.class));
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity toSaveEmployee = modelMapper.map(employeeDTO,EmployeeEntity.class);
        EmployeeEntity savedEmployee = employeeRepository.save(toSaveEmployee);
        return modelMapper.map(savedEmployee,EmployeeDTO.class);
    }


    public void isExistsByEmployeeID(Long id){
        boolean exists = employeeRepository.existsById(id);
        if(!exists) throw new ResourceNotFoundException("Employee Not Found with ID "+ id);
    }
    public EmployeeDTO updateEmployeeByID(EmployeeDTO employeeDTO, Long id) {
        isExistsByEmployeeID(id);
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO,EmployeeEntity.class);
        employeeEntity.setId(id);
        EmployeeEntity saved = employeeRepository.save(employeeEntity);
        return modelMapper.map(saved,EmployeeDTO.class);
    }

    public boolean deleteEmployeeById(long employeeID) {
        isExistsByEmployeeID(employeeID);
        employeeRepository.deleteById(employeeID);
        return true;
    }


    public EmployeeDTO updateEmployeeField(Map<String, Object> updates, Long id) {
        isExistsByEmployeeID(id);
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        updates.forEach((key,value) ->{
            Field field = ReflectionUtils.findRequiredField(EmployeeEntity.class,key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, employeeEntity,value);
        });

        return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);
    }

}
