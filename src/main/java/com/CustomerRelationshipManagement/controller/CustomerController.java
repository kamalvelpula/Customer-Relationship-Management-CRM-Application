package com.CustomerRelationshipManagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.CustomerRelationshipManagement.Entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/insert")
    public String insertCustomer(@RequestBody Customer customer) {

        return customerService.insertCustomer(customer);
    }
    
    @GetMapping("/all")
    public List<Customer> getCustomerList() {

        return customerService.getCustomerList();
    }
    
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {

        return customerService.getCustomerById(id);
    }
    
    @PutMapping("/update")
    public String updateCustomer(@RequestBody Customer customer) {

        return customerService.updateCustomer(customer);
    }
    
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Integer id) {

        return customerService.deleteCustomer(id);
    }
    
    @PostMapping("/insertAll")
    public String insertMultipleCustomers(@RequestBody List<Customer> customers) {

        return customerService.insertMultipleCustomers(customers);
    }
    
    @GetMapping("/search/{firstName}")
    public List<Customer> getCustomersByFirstName(@PathVariable String firstName) {

        return customerService.getCustomersByFirstName(firstName);
    }
    
    @GetMapping("/age/{age}")
    public List<Customer> getCustomersByLessThanAge(@PathVariable int age) {

        return customerService.getCustomersByLessThanAge(age);
    }
    
    @GetMapping("/ageEqual/{age}")
    public List<Customer> getCustomersByAge(@PathVariable int age) {

        return customerService.getCustomersByAge(age);
    }
    
    @GetMapping("/lastname/{lastName}")
    public List<Customer> getCustomersByLastName(@PathVariable String lastName) {

        return customerService.getCustomersByLastName(lastName);
    }
    
    @PutMapping("/updateByFirstName/{firstName}")
    public String updateCustomerByFirstName(@PathVariable String firstName,
                                            @RequestBody Customer customer) {

        return customerService.updateCustomerByFirstName(firstName, customer);
    }
    
    @PutMapping("/updateByLastName/{lastName}")
    public String updateCustomerByLastName(@PathVariable String lastName,
                                           @RequestBody Customer customer) {

        return customerService.updateCustomerByLastName(lastName, customer);
    }
    
    @PutMapping("/updateByEmail/{email}")
    public String updateCustomerByEmail(@PathVariable String email,
                                        @RequestBody Customer customer) {

        return customerService.updateCustomerByEmail(email, customer);
    }
    
    @PutMapping("/updateByMobile/{mobileNumber}")
    public String updateCustomerByMobileNumber(@PathVariable String mobileNumber,
                                               @RequestBody Customer customer) {

        return customerService.updateCustomerByMobileNumber(mobileNumber, customer);
    }
    
    @PutMapping("/updateByAge/{age}")
    public String updateCustomerByAge(@PathVariable int age,
                                      @RequestBody Customer customer) {

        return customerService.updateCustomerByAge(age, customer);
    }
    
    @GetMapping("/pagination")
    public List<Customer> getCustomersWithPagination(@RequestParam int page,
                                                     @RequestParam int size) {

        return customerService.getCustomersWithPagination(page, size);
    }
    
    @GetMapping("/paginationSort")
    public List<Customer> getCustomersWithPaginationAndSorting(@RequestParam int page,
                                                               @RequestParam int size) {

        return customerService.getCustomersWithPagination(page, size);
    }
}