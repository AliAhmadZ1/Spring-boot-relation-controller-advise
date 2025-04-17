package com.example.jpa_relations.Service;

import com.example.jpa_relations.ApiResponse.ApiException;
import com.example.jpa_relations.Model.Customer;
import com.example.jpa_relations.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id, Customer customer){
        Customer oldCustomer = customerRepository.findCustomerById(id);
        if (oldCustomer==null)
            throw new ApiException("customer not found");
        oldCustomer.setPassword(customer.getPassword());
        oldCustomer.setUsername(customer.getUsername());
        customerRepository.save(oldCustomer);
    }

    public void deleteCustomer(Integer id){
        Customer customer = customerRepository.findCustomerById(id);
        if (customer==null)
            throw new ApiException("customer not found or already deleted");
        customerRepository.delete(customer);
    }

}
