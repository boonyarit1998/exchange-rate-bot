package com.npg.payroll.controller;

import com.npg.payroll.entity.Employee;
import com.npg.payroll.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping()
    public List<Employee> getAllEmployee() throws  Exception{
        List<Employee> employeeList = employeeService.getAllEmployee();
        return employeeList;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeByid(@PathVariable Long id) throws  Exception{
        Employee employee = employeeService.getEmployeeById(id);
        return employee;
    }

    @PostMapping()
    public Employee addNewEmployee(@RequestBody Employee newEmployee) throws Exception{
        Employee employee = employeeService.addNewEmployee(newEmployee);
        return employee;
    }

    @PutMapping("/{id}")
    public Employee editEmployee(@RequestBody Employee editEmployee ,@PathVariable Long id) throws  Exception{
         Employee employee = employeeService.editEmployee(id,editEmployee);
         return  employee;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee (@PathVariable Long id) throws  Exception{
        employeeService.deleteEmployee(id);
    }
}
