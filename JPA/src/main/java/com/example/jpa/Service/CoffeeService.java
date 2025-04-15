package com.example.jpa.Service;

import com.example.jpa.ApiResponse.ApiException;
import com.example.jpa.Model.Coffee;
import com.example.jpa.Model.Employee;
import com.example.jpa.Repository.CoffeeRepository;
import com.example.jpa.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class CoffeeService {


    private final CoffeeRepository coffeeRepository;
    private final EmployeeRepository employeeRepository;

    //manual dependency injection
//    public CoffeeRepository(CoffeeRepository coffeeRepository){
//        this.coffeeRepository=coffeeRepository;
//    }
//
//    public CoffeeService(CoffeeRepository coffeeRepository) {
//        this.coffeeRepository = coffeeRepository;
//    }

    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll();
    }

    public void addCoffee(Coffee coffee) {
        Employee employee = employeeRepository.findEmployeesById(coffee.getEmployee_id());
        if (employee == null)
            throw new ApiException("employee ID not found");
        coffeeRepository.save(coffee);
    }

    public void updateCoffee(Integer id, Coffee coffee) {
        Coffee oldCoffee = coffeeRepository.findCoffeeById(id);

        if (oldCoffee == null) {
            throw new ApiException("Coffee not found");
        }

        // best way of update
        oldCoffee.setName(coffee.getName());
        oldCoffee.setCategory(coffee.getCategory());
        oldCoffee.setPrice(coffee.getPrice());

        coffeeRepository.save(oldCoffee);
    }

    public void deleteCoffee(Integer id) {
        Coffee oldCoffee = coffeeRepository.findCoffeeById(id);

        if (oldCoffee == null)
            throw new ApiException("Coffee not found to delete");

        coffeeRepository.delete(oldCoffee);
    }

    public Coffee getById(Integer id) {
        Coffee coffee = coffeeRepository.pleaseGiveMeCoffee(id);
        return coffee;
    }

    public List<Coffee> getByName(String name){
        return coffeeRepository.getByName(name);
    }

    public List<Coffee> getByCategoryAndPrice(String category,Integer price){
        return coffeeRepository.findCoffeeByCategoryAndPrice(category, price);
    }
}
