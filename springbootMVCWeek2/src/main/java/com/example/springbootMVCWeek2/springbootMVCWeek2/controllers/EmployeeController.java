package com.example.springbootMVCWeek2.springbootMVCWeek2.controllers;


import com.example.springbootMVCWeek2.springbootMVCWeek2.dto.EmployeeDTO;
import com.example.springbootMVCWeek2.springbootMVCWeek2.entities.EmployeeEntity;
import com.example.springbootMVCWeek2.springbootMVCWeek2.exceptions.ResourceNotFoundException;
import com.example.springbootMVCWeek2.springbootMVCWeek2.repositories.EmployeeRepository;
import com.example.springbootMVCWeek2.springbootMVCWeek2.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

//    @GetMapping(path = "/password")
//    public String mypassword(){
//        return "my password is this";
//    }

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeID}")
    public ResponseEntity<EmployeeDTO> getEmployeeByID(@PathVariable(name = "employeeID") Long id){
       // return new EmployeeDTO(id,"rishu","rishu@gamil.com",26, LocalDate.of(2024,12,17),true);
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeByID(id);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElseThrow(() ->  new ResourceNotFoundException("employee not found with ID "+ id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam (required = false) Integer age,
                                                @RequestParam (required = false) String msg){


       // return "my age is " + age + "and my msg is " + msg;
        return ResponseEntity.ok(employeeService.getAllEmployees());

    }



    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO EmployeeDTO){
//        employeeDTO.setId(100L);
//        return employeeDTO;
        return new ResponseEntity<>(employeeService.createNewEmployee(EmployeeDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeID}")
    public ResponseEntity<EmployeeDTO> updateEmployeeByID(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeID){
        return ResponseEntity.ok(employeeService.updateEmployeeByID(employeeDTO, employeeID));
    }

    @DeleteMapping(path = "/{employeeID}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable long employeeID){
        boolean deleted = employeeService.deleteEmployeeById(employeeID);
        if(!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(true);
    }

    @PatchMapping(path = "/{employeeID}")
    public ResponseEntity<EmployeeDTO> updateEmployeeField(@RequestBody Map<String,Object> updates, @PathVariable Long employeeID){
        EmployeeDTO employeeDTO = employeeService.updateEmployeeField(updates,employeeID);
        if(employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }
}
