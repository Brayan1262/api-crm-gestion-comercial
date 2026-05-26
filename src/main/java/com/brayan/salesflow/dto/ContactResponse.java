package com.brayan.salesflow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String position;
    private Long customerId;
    private String customerName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
