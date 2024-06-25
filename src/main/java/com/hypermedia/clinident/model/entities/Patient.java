package com.hypermedia.clinident.model.entities;

import com.hypermedia.clinident.model.dto.EmergencyContact;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private LocalDate birthdate;
    private String phone;
    @Column(unique = true)
    private String email;

}
