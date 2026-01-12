package com.npg.payroll.service;

import com.npg.payroll.entity.Employee;
import com.npg.payroll.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() throws Exception{
        List<Employee> employeeList = employeeRepository.findAll();
        return  employeeList;
    };

    public Employee getEmployeeById(Long id) throws  Exception{
        Employee employee = employeeRepository.findById(id).orElse(null);
        return employee;
    };
    public Employee addNewEmployee(Employee newEmployee) throws Exception{
        Employee add = new Employee();
        add.setFirstName(newEmployee.getFirstName());
        add.setLastName(newEmployee.getLastName());
        add.setEmployeeId(newEmployee.getEmployeeId());
        Employee employee = employeeRepository.save(add);
        return  employee;
    };
    public Employee editEmployee(Long id ,Employee employee) throws  Exception{
        Employee edit = employeeRepository.findById(id).orElse(null);
        if(edit != null){
            edit.setFirstName(employee.getFirstName());
            edit.setLastName(employee.getLastName());
            edit.setEmployeeId(employee.getEmployeeId());
            Employee result = employeeRepository.save(edit);
        }
        return  null;

    };


    public void deleteEmployee(Long id) throws Exception{
        Employee delete = employeeRepository.findById(id).orElse(null);
        if(delete != null){
            employeeRepository.deleteById(id);
        }

    };
}
