package com.brayan.salesflow.repository;

import com.brayan.salesflow.entity.Customer;
import com.brayan.salesflow.entity.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByRuc(String ruc);

    List<Customer> findByStatus(CustomerStatus status);

    List<Customer> findByCompanyNameContainingIgnoreCase(String companyName);

}
