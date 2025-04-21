package com.example.miniapp.repositories;

import com.example.miniapp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Find customers by email domain
    @Query("SELECT c FROM Customer c WHERE c.email LIKE %?1")
    List<Customer> findCustomersByEmailDomain(@Param("domain")String domain);

    // Find customers by phone prefix
//    @Query("SELECT c FROM Customer c WHERE c.phoneNumber LIKE ?1%")
//    List<Customer> findCustomersByPhonePrefix(@Param("prefix")String prefix);

    @Query("SELECT c FROM Customer c WHERE c.phoneNumber LIKE CONCAT(:prefix, '%')")
    List<Customer> findCustomersByPhonePrefix(@Param("prefix") String prefix);

}
