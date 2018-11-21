package com.ensi.ilsi.myClinic.web.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.ensi.ilsi.myClinic.domain.Consultation;


public class PatientDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private LocalDateTime birthDate;
    private String gender;
    private Set<ConsultationDto> consultations;
    private Boolean enabled;
    

    public PatientDto() {
        // JPA
    }

    public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public PatientDto(Long id, String firstName, String lastName, String email, String telephone,LocalDateTime birthDate,String gender,Set<ConsultationDto> consultations, Boolean enabled) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.birthDate = birthDate;
        this.gender = gender;
        this.consultations = consultations;
        this.enabled = enabled;
        
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

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<ConsultationDto> getConsultations() {
        return consultations;
    }

    public void setConsultations(Set<ConsultationDto> consultations) {
        this.consultations = consultations;
    }
    
    
}
