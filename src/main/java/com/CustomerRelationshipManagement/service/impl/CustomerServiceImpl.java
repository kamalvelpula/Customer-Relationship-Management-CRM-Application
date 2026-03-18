package com.CustomerRelationshipManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.Entity.Customer;
import com.CustomerRelationshipManagement.dao.CustomerDao;
import com.CustomerRelationshipManagement.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public String insertCustomer(Customer customer) {

        return customerDao.insertCustomer(customer);
    }
    
    @Override
    public List<Customer> getCustomerList() {

        return customerDao.getCustomerList();
    }
    
    @Override
    public Customer getCustomerById(Integer id) {

        return customerDao.getCustomerById(id);
    }
    
    @Override
    public String updateCustomer(Customer customer) {

        return customerDao.updateCustomer(customer);
    }
    
    @Override
    public String deleteCustomer(Integer id) {

        return customerDao.deleteCustomer(id);
    }
    
    @Override
    public String insertMultipleCustomers(List<Customer> customers) {

        return customerDao.insertMultipleCustomers(customers);
    }
    
    @Override
    public List<Customer> getCustomersByFirstName(String firstName) {

        return customerDao.getCustomersByFirstName(firstName);
    }
    
    @Override
    public List<Customer> getCustomersByLessThanAge(int age) {

        return customerDao.getCustomersByLessThanAge(age);
    }
    
    @Override
    public List<Customer> getCustomersByAge(int age) {

        return customerDao.getCustomersByAge(age);
    }
    
    @Override
    public List<Customer> getCustomersByLastName(String lastName) {

        return customerDao.getCustomersByLastName(lastName);
    }
    
    @Override
    public String updateCustomerByFirstName(String firstName, Customer customer) {

        return customerDao.updateCustomerByFirstName(firstName, customer);
    }
    
    @Override
    public String updateCustomerByLastName(String lastName, Customer customer) {

        return customerDao.updateCustomerByLastName(lastName, customer);
    }
    
    @Override
    public String updateCustomerByEmail(String email, Customer customer) {

        return customerDao.updateCustomerByEmail(email, customer);
    }
    
    @Override
    public String updateCustomerByMobileNumber(String mobileNumber, Customer customer) {

        return customerDao.updateCustomerByMobileNumber(mobileNumber, customer);
    }
    
    @Override
    public String updateCustomerByAge(int age, Customer customer) {

        return customerDao.updateCustomerByAge(age, customer);
    }
    
    @Override
    public List<Customer> getCustomersWithPagination(int page, int size) {

        return customerDao.getCustomersWithPagination(page, size);
    }
}