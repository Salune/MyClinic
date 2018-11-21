package com.ensi.ilsi.myClinic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.Objects;
import java.util.Set;

/**
 * A Customer.
 */
@Entity
@Table(name = "doctor")
public class Doctor extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private Set<Patient> patients;
    
    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private Set<Consultation> consultations;

    @Column(name = "speciality", nullable = false)
    private String speciality;

    public Doctor() {
        // JPA
    }

    public Doctor(String firstName, String lastName, @Email String email,
                    String telephone,String speciality, Set<Patient> patients,Set<Consultation> consultations) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.speciality=speciality;
        this.patients = patients;
        this.consultations = consultations;
        
    }

    public Set<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(Set<Consultation> consultations) {
		this.consultations = consultations;
	}

	public Set<Patient> getPatients() {
		return patients;
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

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(firstName, doctor.firstName) &&
                Objects.equals(lastName, doctor.lastName) &&
                Objects.equals(email, doctor.email) &&
                Objects.equals(telephone, doctor.telephone) &&
                Objects.equals(speciality, doctor.speciality)&&
                Objects.equals(patients, doctor.patients);
               
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, telephone, patients, speciality,consultations);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", patients=" + patients +
                ", speciality=" + speciality +
                ", consultations=" + consultations +
                '}';
    }
}
