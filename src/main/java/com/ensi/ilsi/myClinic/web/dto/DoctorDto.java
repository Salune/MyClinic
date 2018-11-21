/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.myClinic.web.dto;

import java.util.Set;

import com.ensi.ilsi.myClinic.domain.Consultation;
import com.ensi.ilsi.myClinic.domain.Patient;

/**
 * @author n.lamouchi
 */
public class DoctorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String speciality;
    private Set<PatientDto> patients;
    private Set<ConsultationDto> consultations;
    public DoctorDto() {
        // JACKSON
    }

    public DoctorDto(Long id, String firstName, String lastName, String email, String telephone, String speciality,Set<PatientDto> patients, Set<ConsultationDto> consultations) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.speciality = speciality;
        this.patients = patients;
        this.consultations = consultations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<PatientDto> getPatients() {
		return patients;
	}

	public void setPatients(Set<PatientDto> patients) {
		this.patients = patients;
	}

	public Set<ConsultationDto> getConsultations() {
		return consultations;
	}

	public void setConsultations(Set<ConsultationDto> consultations) {
		this.consultations = consultations;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
    
}
