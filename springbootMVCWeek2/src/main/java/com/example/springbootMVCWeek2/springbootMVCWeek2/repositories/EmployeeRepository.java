package com.example.springbootMVCWeek2.springbootMVCWeek2.repositories;

import com.example.springbootMVCWeek2.springbootMVCWeek2.dto.EmployeeDTO;
import com.example.springbootMVCWeek2.springbootMVCWeek2.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {



}
