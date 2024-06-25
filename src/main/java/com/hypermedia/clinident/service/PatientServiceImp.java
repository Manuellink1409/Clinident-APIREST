package com.hypermedia.clinident.service;

import com.hypermedia.clinident.model.dto.PatientListResponse;
import com.hypermedia.clinident.model.dto.PatientRequest;
import com.hypermedia.clinident.model.entities.Patient;
import com.hypermedia.clinident.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImp implements PatientService{

    private final PatientRepository patientRepository;

    @Override
    public String createPatient(PatientRequest patient) {
        Patient newPatient = Patient.builder()
                .fullname(patient.getFirstName()+" "+patient.getLastName())
                .birthdate(patient.getBirthDate())
                .phone(patient.getPhone())
                .email(patient.getEmail())
                .build();
        patientRepository.save(newPatient);
        return newPatient.getId().toString();
    }

    @Override
    public String updatePatient(PatientRequest patient, Long id) {
        Patient patientDB = patientRepository.findById(id).orElseThrow();
            patientDB.setFullname(patient.getFirstName()+" "+patient.getLastName());
            patientDB.setPhone(patient.getPhone());
            patientDB.setBirthdate(patient.getBirthDate());
            patientDB.setEmail(patient.getEmail());
            patientRepository.save(patientDB);
        return patientDB.getId().toString();
    }

    @Override
    public Boolean existsPatient(long id) {
        return patientRepository.existsById(id);
    }

    @Override
    public PatientListResponse getAllPatientsWithPagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Patient> patientPage = patientRepository.findAll(pageable);

        List<Patient> patients = patientRepository.findAll(pageable).getContent();

        return new PatientListResponse(patients
                ,pageNumber
                ,pageSize
                ,patientPage.getTotalElements()
                ,patientPage.getTotalPages()
                ,patientPage.isLast());
    }

}
