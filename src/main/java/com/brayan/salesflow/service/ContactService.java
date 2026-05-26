package com.brayan.salesflow.service;

import com.brayan.salesflow.dto.ContactRequest;
import com.brayan.salesflow.dto.ContactResponse;
import com.brayan.salesflow.entity.Contact;
import com.brayan.salesflow.entity.Customer;
import com.brayan.salesflow.exception.BadRequestException;
import com.brayan.salesflow.exception.ResourceNotFoundException;
import com.brayan.salesflow.repository.ContactRepository;
import com.brayan.salesflow.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final CustomerRepository customerRepository;

    public ContactResponse create(ContactRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        if (request.getEmail() != null && !request.getEmail().isBlank() 
            && contactRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("El email del contacto ya se encuentra registrado");
        }

        Contact contact = Contact.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .position(request.getPosition())
                .customer(customer)
                .build();

        Contact saved = contactRepository.save(contact);
        return mapToResponse(saved);
    }

    public List<ContactResponse> findAll() {
        return contactRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ContactResponse findById(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contacto no encontrado"));
        return mapToResponse(contact);
    }

    public List<ContactResponse> findByCustomerId(Long customerId) {
        customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        return contactRepository.findByCustomerId(customerId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ContactResponse update(Long id, ContactRequest request) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contacto no encontrado"));

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        if (request.getEmail() != null && !request.getEmail().isBlank() 
            && contactRepository.existsByEmail(request.getEmail()) 
            && !request.getEmail().equals(contact.getEmail())) {
            throw new BadRequestException("El email del contacto ya se encuentra registrado");
        }

        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        contact.setPhone(request.getPhone());
        contact.setPosition(request.getPosition());
        contact.setCustomer(customer);

        Contact saved = contactRepository.save(contact);
        return mapToResponse(saved);
    }

    public void delete(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contacto no encontrado"));
        contactRepository.delete(contact);
    }

    private ContactResponse mapToResponse(Contact contact) {
        return ContactResponse.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .email(contact.getEmail())
                .phone(contact.getPhone())
                .position(contact.getPosition())
                .customerId(contact.getCustomer().getId())
                .customerName(contact.getCustomer().getCompanyName())
                .createdAt(contact.getCreatedAt())
                .updatedAt(contact.getUpdatedAt())
                .build();
    }

}
