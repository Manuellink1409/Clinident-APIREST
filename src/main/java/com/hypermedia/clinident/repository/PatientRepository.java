package com.hypermedia.clinident.repository;

import com.hypermedia.clinident.model.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
