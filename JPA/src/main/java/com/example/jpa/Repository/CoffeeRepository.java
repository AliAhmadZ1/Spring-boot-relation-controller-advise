package com.example.jpa.Repository;

import com.example.jpa.Model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {


    Coffee findCoffeeById(Integer id);

    @Query("select c from Coffee c where c.id=?1") // ? parameter position
    Coffee pleaseGiveMeCoffee(Integer id);


    List<Coffee> findCoffeeByName(String name);

    @Query("select c from Coffee c where c.name=?1")
    List<Coffee> getByName(String name);

    List<Coffee> findCoffeeByCategoryAndPrice(String category,Integer price);

}
