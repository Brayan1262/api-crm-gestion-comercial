package com.brayan.salesflow.repository;

import com.brayan.salesflow.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByCustomerId(Long customerId);

    boolean existsByEmail(String email);

}
