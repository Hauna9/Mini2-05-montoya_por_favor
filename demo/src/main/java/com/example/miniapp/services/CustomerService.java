
package com.example.miniapp.services;

import com.example.miniapp.models.Customer;
import com.example.miniapp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Add a new customer
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get customer by ID
    public Customer getCustomerById(long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    // Update customer
    public Customer updateCustomer(long id, Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            return customerRepository.save(customer);
        }
        return null;
    }

    // Delete customer
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }

    // Find customers by email domain
    public List<Customer> findCustomersByEmailDomain(String domain) {
        return customerRepository.findCustomersByEmailDomain(domain);
    }

    // Find customers by phone prefix
    public List<Customer> findCustomersByPhonePrefix(String prefix) {
        return customerRepository.findCustomersByPhonePrefix(prefix);
    }
}
