package com.CustomerRelationshipManagement.service;

import java.util.List;

import com.CustomerRelationshipManagement.Entity.Customer;

public interface CustomerService {

    String insertCustomer(Customer customer);
    
    List<Customer> getCustomerList();
    
    Customer getCustomerById(Integer id);
    
    String updateCustomer(Customer customer);
    
    String deleteCustomer(Integer id);
    
    String insertMultipleCustomers(List<Customer> customers);
    
    List<Customer> getCustomersByFirstName(String firstName);
    
    List<Customer> getCustomersByLessThanAge(int age);
    
    List<Customer> getCustomersByAge(int age);
    
    List<Customer> getCustomersByLastName(String lastName);
    
    String updateCustomerByFirstName(String firstName, Customer customer);
    
    String updateCustomerByLastName(String lastName, Customer customer);
    
    String updateCustomerByEmail(String email, Customer customer);
    
    String updateCustomerByMobileNumber(String mobileNumber, Customer customer);
    
    String updateCustomerByAge(int age, Customer customer);
    
    List<Customer> getCustomersWithPagination(int page, int size);
}