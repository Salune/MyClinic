package com.ensi.ilsi.myClinic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ensi.ilsi.myClinic.web.dto.ConsultationDto;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "patient")
public class Patient extends AbstractEntity {

    
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;
    
    @Column(name = "birthDate")
    private LocalDateTime birthDate;
    
    @Column(name = "gender")
    private String gender;
     
    @Column(name = "enabled")
    private Boolean enabled;
    
    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<Consultation> consultations;

   

    public Patient() {
        // JPA
    }

    public Patient(String firstName, String lastName, @Email String email,
                    String telephone,LocalDateTime birthDate,String gender,Boolean enabled,Set<Consultation> consultations) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.birthDate = birthDate;
        this.gender = gender;
        this.enabled= enabled;
        this.consultations= consultations;
        
       
        
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

    public String getGender() {
        return gender;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(Set<Consultation> consultations) {
        this.consultations = consultations;
    }

   

   

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
         return Objects.equals(firstName, patient.firstName) &&
                Objects.equals(lastName, patient.lastName) &&
                Objects.equals(email, patient.email) &&
                Objects.equals(telephone, patient.telephone) &&
                Objects.equals(birthDate, patient.birthDate) &&
                Objects.equals(gender, patient.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, telephone, birthDate,gender,enabled,consultations);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birthDate=" + birthDate+
                ", gender=" + gender +
                ",  enabled=" + enabled +
                ",  consultations=" + consultations +
                '}';
    }
}
