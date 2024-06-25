package com.hypermedia.clinident.model.dto;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequest {

    @NotNull(message = "firstName atribute cannot be null")
    private String firstName;
    @NotNull(message = "lastname atribute cannot be null")
    private String lastName;
    @NotNull(message = "birthdate atribute cannot be null")
    private LocalDate birthDate;
    @NotNull(message = "phone atribute cannot be null")
    private String phone;
    @NotNull(message = "email atribute cannot be null")
    @Email(message = "Email have to contain @ and .")
    private String email;

}
