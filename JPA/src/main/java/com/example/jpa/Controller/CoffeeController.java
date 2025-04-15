package com.example.jpa.Controller;

import com.example.jpa.ApiResponse.ApiResponse;
import com.example.jpa.Model.Coffee;
import com.example.jpa.Service.CoffeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coffee")
@RequiredArgsConstructor
public class CoffeeController {

    private final CoffeeService coffeeService;

    @GetMapping("/get")
    public ResponseEntity getAllCoffee() {

//        List<Coffee> coffeeList= coffeeService.getAllCoffee();
        return ResponseEntity.status(200).body(coffeeService.getAllCoffee());
    }

    @PostMapping("/add")
    public ResponseEntity addCoffee(@RequestBody @Valid Coffee coffee) {
        coffeeService.addCoffee(coffee);
        return ResponseEntity.status(200).body(new ApiResponse("coffee is added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCoffee(@PathVariable Integer id, @RequestBody @Valid Coffee coffee) {
        coffeeService.updateCoffee(id, coffee);
        return ResponseEntity.status(200).body(new ApiResponse("coffee is updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCoffee(@PathVariable Integer id) {
        coffeeService.deleteCoffee(id);
        return ResponseEntity.status(200).body(new ApiResponse("is Deleted"));
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(coffeeService.getById(id));
    }

    @GetMapping("/get-name/{name}")
    public ResponseEntity getByName(@PathVariable String name) {
        return ResponseEntity.status(200).body(coffeeService.getByName(name));
    }

    @GetMapping("/get-category-price/{category},{price}")
    public ResponseEntity getByCategoryAndPrice(@PathVariable String category, @PathVariable Integer price) {
        return ResponseEntity.status(200).body(coffeeService.getByCategoryAndPrice(category, price));
    }

}
