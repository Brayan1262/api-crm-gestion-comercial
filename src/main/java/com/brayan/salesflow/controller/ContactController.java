package com.brayan.salesflow.controller;

import com.brayan.salesflow.dto.ContactRequest;
import com.brayan.salesflow.dto.ContactResponse;
import com.brayan.salesflow.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<ContactResponse> create(@Valid @RequestBody ContactRequest request) {
        ContactResponse response = contactService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<ContactResponse> findAll() {
        return contactService.findAll();
    }

    @GetMapping("/{id}")
    public ContactResponse findById(@PathVariable Long id) {
        return contactService.findById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<ContactResponse> findByCustomerId(@PathVariable Long customerId) {
        return contactService.findByCustomerId(customerId);
    }

    @PutMapping("/{id}")
    public ContactResponse update(@PathVariable Long id, @Valid @RequestBody ContactRequest request) {
        return contactService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contactService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
