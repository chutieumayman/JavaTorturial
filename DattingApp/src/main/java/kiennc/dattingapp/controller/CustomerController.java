package kiennc.dattingapp.controller;

import kiennc.dattingapp.repository.CustomerRepository;
import kiennc.dattingapp.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/customer/add")
    public  String addCustomer(@RequestParam String firstName, @RequestParam String lastName){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(firstName);
        customerEntity.setLastName(lastName);
        customerRepository.save(customerEntity);
        return  "Success";
    }

    @GetMapping("/customer/list")
    public  Iterable<CustomerEntity> getCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/customer/find/{id}")
    public CustomerEntity getCustomerById(@PathVariable Integer id)
    {
        return customerRepository.getById(id);
    }
}
