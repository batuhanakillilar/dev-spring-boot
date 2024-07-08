package com.batu.springboot.cruddemo.dao;

import com.batu.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //no need to write code


}
