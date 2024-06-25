package com.hypermedia.clinident.controller;


import com.hypermedia.clinident.model.dto.PatientListResponse;
import com.hypermedia.clinident.model.dto.PatientRequest;
import com.hypermedia.clinident.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<PatientListResponse> getPatients(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                           @RequestParam Integer pageSize) {
        return ResponseEntity.ok(patientService.getAllPatientsWithPagination(pageNumber,pageSize));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boolean> existsPatient(@PathVariable long id) {
        return ResponseEntity.ok(patientService.existsPatient(id));
    }

    @PostMapping
    public ResponseEntity<String> createPatient(@RequestBody @Valid PatientRequest patient) {
        return ResponseEntity.ok(patientService.createPatient(patient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePatient(@RequestBody @Valid PatientRequest patient, @PathVariable Long id) {
        return ResponseEntity.ok(patientService.updatePatient(patient,id));
    }

    @PutMapping("/{id}/disabled")
    public ResponseEntity<String> disabledPatient(@RequestBody @Valid PatientRequest patient, @PathVariable Long id) {
        return ResponseEntity.ok("Orale master");
    }
}
