package com.batu.springboot.cruddemo.rest;

import com.batu.springboot.cruddemo.dao.EmployeeDAO;
import com.batu.springboot.cruddemo.entity.Employee;
import com.batu.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    /*
    private EmployeeDAO employeeDAO;

    //quick and dirty: inject employee DAO
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }*/

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService TheEmployeeService) {
        employeeService = TheEmployeeService;
    }
    //expose the "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return  employeeService.findAll();
    }

    @GetMapping("employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee emp = employeeService.findById(employeeId);

        if(emp == null){
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }
        else{
            return emp;
        }
    }

    //Add mapping for post employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp) {

        //Also just in case they pass an id in JSON... set id to 0
        //this is to force a save in new item
        emp.setId(0);
        Employee emp1 = employeeService.save(emp);
        return emp1;

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp) {
        Employee emp1 = employeeService.save(emp);

        return emp1;
    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee emp = employeeService.findById(employeeId);
        if(emp == null){
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }
        else{
            employeeService.deleteById(employeeId);

            return "Employee with id " + employeeId + " deleted";

        }

    }



}
