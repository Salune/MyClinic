package com.ensi.ilsi.myClinic.service;

import com.ensi.ilsi.myClinic.domain.Patient;
import com.ensi.ilsi.myClinic.repository.PatientRepository;
import com.ensi.ilsi.myClinic.web.dto.PatientDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientService {
    private final Logger log = LoggerFactory.getLogger(PatientService.class);

    private final PatientRepository patientRepository;

        public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientDto create(PatientDto patientDto) {
        log.debug("Request to create Patient : {}", patientDto);
        return mapToDto(
                this.patientRepository.save(
                        new Patient(
                                patientDto.getFirstName(),
                                patientDto.getLastName(),
                                patientDto.getEmail(),
                                patientDto.getTelephone(),
                                patientDto.getBirthDate(),
                                patientDto.getGender(),
                                Boolean.TRUE,
                                Collections.emptySet()
                                
                               
                        )
                )
        );
    }

    public List<PatientDto> findAll() {
        log.debug("Request to get all Patients");
        return this.patientRepository.findAll()
                .stream()
                .map(PatientService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PatientDto findById(Long id) {
        log.debug("Request to get Patient : {}", id);
        return this.patientRepository.findById(id).map(PatientService::mapToDto).orElse(null);
    }

    public List<PatientDto> findAllActive() {
        log.debug("Request to get all Patients");
        return this.patientRepository.findAllByEnabled(true)
                .stream()
                .map(PatientService::mapToDto)
                .collect(Collectors.toList());
    }

    public List<PatientDto> findAllInactive() {
        log.debug("Request to get all Patients");
        return this.patientRepository.findAllByEnabled(false)
                .stream()
                .map(PatientService::mapToDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        log.debug("Request to delete Patient : {}", id);

        Patient patient = this.patientRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Patient with id " + id));

        patient.setEnabled(false);
        this.patientRepository.save(patient);
    }

    public static PatientDto mapToDto(Patient patient) {
        if (patient != null) {
            return new PatientDto(
            		patient.getId(),
                    patient.getFirstName(),
                    patient.getLastName(),
                    patient.getEmail(),
                    patient.getTelephone(),
                    patient.getBirthDate(),
                    patient.getGender(),
                    patient.getConsultations().stream().map(ConsultationService::mapToDto).collect(Collectors.toSet())
                   ,patient.getEnabled()
                    
            		);
        }
        return null;
    }

}
