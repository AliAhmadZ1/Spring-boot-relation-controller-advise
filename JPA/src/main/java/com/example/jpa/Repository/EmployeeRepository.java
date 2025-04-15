package com.example.jpa.Repository;

import com.example.jpa.Model.Employee;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee findEmployeesById(Integer id);

    @Query("select e from Employee e where e.age>=?1 and e.age<=?2")
    List<Employee> getRangeAge(Integer fAge,Integer sAge);

}
