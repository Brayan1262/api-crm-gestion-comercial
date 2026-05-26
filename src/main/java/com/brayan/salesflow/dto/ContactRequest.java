package com.brayan.salesflow.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {

    @NotBlank(message = "firstName is required")
    @Size(max = 80)
    private String firstName;

    @NotBlank(message = "lastName is required")
    @Size(max = 80)
    private String lastName;

    @Email
    @Size(max = 120)
    private String email;

    @Size(max = 30)
    private String phone;

    @Size(max = 80)
    private String position;

    @NotNull(message = "customerId is required")
    private Long customerId;

}
