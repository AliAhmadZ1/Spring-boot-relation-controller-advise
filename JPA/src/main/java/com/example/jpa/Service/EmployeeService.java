package com.example.jpa.Service;

import com.example.jpa.Model.Employee;
import com.example.jpa.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Boolean updateEmployee(Integer id, Employee employee) {
        Employee oldEmployee = employeeRepository.findEmployeesById(id);
        if (oldEmployee == null)
            return false;
        oldEmployee.setName(employee.getName());
        oldEmployee.setEmail(employee.getEmail());
        oldEmployee.setAge(employee.getAge());
        oldEmployee.setIs_leave(employee.getIs_leave());
        employeeRepository.save(oldEmployee);
        return true;

    }

    public Boolean deleteEmployee(Integer id) {
        Employee oldEmployee = employeeRepository.findEmployeesById(id);
        if (oldEmployee == null)
            return false;
        employeeRepository.delete(oldEmployee);
        return true;
    }

    public List<Employee> getByAge(Integer fAge,Integer sAge){
        return employeeRepository.getRangeAge(fAge, sAge);
    }



}
