package com.example.jpa.Controller;

import com.example.jpa.ApiResponse.ApiResponse;
import com.example.jpa.Model.Employee;
import com.example.jpa.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/get")
    public ResponseEntity getAllEmployee(){
        if (employeeService.getAllEmployee().isEmpty())
            return ResponseEntity.status(400).body(new ApiResponse("there are no employee"));
        return ResponseEntity.status(200).body(employeeService.getAllEmployee());
    }

    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody@Valid Employee employee, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        employeeService.addEmployee(employee);
        return ResponseEntity.status(200).body(new ApiResponse("new Employee is added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateEmployee(@PathVariable Integer id,@RequestBody@Valid Employee employee,Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        boolean isUpdated = employeeService.updateEmployee(id, employee);
        if (isUpdated)
            return ResponseEntity.status(200).body(new ApiResponse("employee is updated"));
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Integer id){
        boolean isDeleted = employeeService.deleteEmployee(id);
        if (isDeleted)
            return ResponseEntity.status(200).body(new ApiResponse("this employee is deleted"));
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

    @GetMapping("/range-age/{fAge},{sAge}")
    public ResponseEntity getByAge(@PathVariable Integer fAge,@PathVariable Integer sAge){
        return ResponseEntity.status(200).body(employeeService.getByAge(fAge,sAge));
    }

}
