package com.hypermedia.clinident.model.dto;

import com.hypermedia.clinident.model.entities.Patient;

import java.util.List;

public record PatientListResponse(List<Patient> patientList,
                                  Integer pageNumber,
                                  Integer pageSize,
                                  Long totalElements,
                                  int totalPages,
                                  boolean isLast) {
}
