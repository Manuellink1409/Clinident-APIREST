package com.hypermedia.clinident.service;

import com.hypermedia.clinident.model.dto.PatientListResponse;
import com.hypermedia.clinident.model.dto.PatientRequest;
import com.hypermedia.clinident.model.entities.Patient;

import java.net.URI;
import java.util.List;

public interface PatientService {

    String createPatient(PatientRequest patient);

    String updatePatient(PatientRequest patient, Long id);

    Boolean existsPatient(long id);

    PatientListResponse getAllPatientsWithPagination(Integer pageNumber, Integer pageSize);
}
