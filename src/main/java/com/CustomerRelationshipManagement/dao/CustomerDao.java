package com.CustomerRelationshipManagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.CustomerRelationshipManagement.Entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public String insertCustomer(Customer customer) {

        entityManager.persist(customer);

        return "Customer Inserted Successfully";
    }
    
    public List<Customer> getCustomerList() {

        List<Customer> customers = entityManager
                .createQuery("from Customer", Customer.class)
                .getResultList();

        return customers;
    }
    
    public Customer getCustomerById(Integer id) {

        Customer customer = entityManager.find(Customer.class, id);

        return customer;
    }
    
    @Transactional
    public String updateCustomer(Customer customer) {

        entityManager.merge(customer);

        return "Customer Updated Successfully";
    }
    
    @Transactional
    public String deleteCustomer(Integer id) {

        Customer customer = entityManager.find(Customer.class, id);

        if (customer != null) {
            entityManager.remove(customer);
            return "Customer Deleted Successfully";
        } else {
            return "Customer Not Found";
        }
    }
    
    @Transactional
    public String insertMultipleCustomers(List<Customer> customers) {

        for (Customer customer : customers) {
            entityManager.persist(customer);
        }

        return "All Customers Inserted Successfully";
    }
    
    @Transactional
    public List<Customer> getCustomersByFirstName(String firstName) {

        String hql = "FROM Customer WHERE firstName = :firstName";

        return entityManager.createQuery(hql, Customer.class)
                .setParameter("firstName", firstName)
                .getResultList();
    }
    
    @Transactional
    public List<Customer> getCustomersByLessThanAge(int age) {

        String hql = "FROM Customer WHERE age < :age";

        return entityManager.createQuery(hql, Customer.class)
                .setParameter("age", age)
                .getResultList();
    }
    
    @Transactional
    public List<Customer> getCustomersByAge(int age) {

        String hql = "FROM Customer WHERE age = :age";

        return entityManager.createQuery(hql, Customer.class)
                .setParameter("age", age)
                .getResultList();
    }
    
    @Transactional
    public List<Customer> getCustomersByLastName(String lastName) {

        String hql = "FROM Customer WHERE lastName = :lastName";

        return entityManager.createQuery(hql, Customer.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }
    
    @Transactional
    public String updateCustomerByFirstName(String firstName, Customer newData) {

        String hql = "FROM Customer WHERE firstName = :firstName";

        List<Customer> list = entityManager.createQuery(hql, Customer.class)
                .setParameter("firstName", firstName)
                .getResultList();

        if (list.isEmpty()) {
            return "No Customers Found";
        }

        for (Customer customer : list) {

            customer.setLastName(newData.getLastName());
            customer.setEmail(newData.getEmail());
            customer.setMobileNumber(newData.getMobileNumber());
            customer.setAge(newData.getAge());

            entityManager.merge(customer);
        }

        return "Customers Updated Successfully";
    }
    
    @Transactional
    public String updateCustomerByLastName(String lastName, Customer newData) {

        String hql = "FROM Customer WHERE lastName = :lastName";

        List<Customer> list = entityManager.createQuery(hql, Customer.class)
                .setParameter("lastName", lastName)
                .getResultList();

        if (list.isEmpty()) {
            return "No Customers Found";
        }

        for (Customer customer : list) {

            customer.setFirstName(newData.getFirstName());
            customer.setEmail(newData.getEmail());
            customer.setMobileNumber(newData.getMobileNumber());
            customer.setAge(newData.getAge());

            entityManager.merge(customer);
        }

        return "Customers Updated Successfully";
    }
    
    @Transactional
    public String updateCustomerByEmail(String email, Customer newData) {

        String hql = "FROM Customer WHERE email = :email";

        List<Customer> list = entityManager.createQuery(hql, Customer.class)
                .setParameter("email", email)
                .getResultList();

        if (list.isEmpty()) {
            return "Customer Not Found";
        }

        for (Customer customer : list) {

            customer.setFirstName(newData.getFirstName());
            customer.setLastName(newData.getLastName());
            customer.setMobileNumber(newData.getMobileNumber());
            customer.setAge(newData.getAge());

            entityManager.merge(customer);
        }

        return "Customer Updated Successfully";
    }
    
    @Transactional
    public String updateCustomerByMobileNumber(String mobileNumber, Customer newData) {

        String hql = "FROM Customer WHERE mobileNumber = :mobileNumber";

        List<Customer> list = entityManager.createQuery(hql, Customer.class)
                .setParameter("mobileNumber", mobileNumber)
                .getResultList();

        if (list.isEmpty()) {
            return "Customer Not Found";
        }

        for (Customer customer : list) {

            customer.setFirstName(newData.getFirstName());
            customer.setLastName(newData.getLastName());
            customer.setEmail(newData.getEmail());
            customer.setAge(newData.getAge());

            entityManager.merge(customer);
        }

        return "Customer Updated Successfully";
    }
    
    @Transactional
    public String updateCustomerByAge(int age, Customer newData) {

        String hql = "FROM Customer WHERE age = :age";

        List<Customer> list = entityManager.createQuery(hql, Customer.class)
                .setParameter("age", age)
                .getResultList();

        if (list.isEmpty()) {
            return "No Customers Found";
        }

        for (Customer customer : list) {

            customer.setFirstName(newData.getFirstName());
            customer.setLastName(newData.getLastName());
            customer.setEmail(newData.getEmail());
            customer.setMobileNumber(newData.getMobileNumber());

            entityManager.merge(customer);
        }

        return "Customers Updated Successfully";
    }
    
    @Transactional
    public List<Customer> getCustomersWithPagination(int page, int size) {

        String hql = "FROM Customer";

        return entityManager.createQuery(hql, Customer.class)
                .setFirstResult(page * size) // starting index
                .setMaxResults(size)         // limit
                .getResultList();
    }
    
    @Transactional
    public List<Customer> getCustomersWithPaginationAndSorting(int page, int size) {

        String hql = "FROM Customer ORDER BY age DESC";

        return entityManager.createQuery(hql, Customer.class)
                .setFirstResult(page * size)
                .setMaxResults(size)
                .getResultList();
    }
}