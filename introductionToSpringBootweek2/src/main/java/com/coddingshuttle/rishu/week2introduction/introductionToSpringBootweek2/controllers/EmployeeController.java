package com.coddingshuttle.rishu.week2introduction.introductionToSpringBootweek2.controllers;


import com.coddingshuttle.rishu.week2introduction.introductionToSpringBootweek2.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class EmployeeController {


    @GetMapping(path = "/employees/{employeeID}")
    public EmployeeDTO employee(@PathVariable Long employeeID){
        return new EmployeeDTO(employeeID, "name", "email", 12, LocalDate.of(2024,9,23), true);
    }

    @GetMapping(path = "/employees")
    public String getEmployee(@RequestParam (required = false) Long age,
                              @RequestParam (required = false) String name){


        return age + " " + name;

    }

    @PostMapping(path = "/employees")
    public String createNewEmployee(){
        return "hello from post";
    }

   


}
