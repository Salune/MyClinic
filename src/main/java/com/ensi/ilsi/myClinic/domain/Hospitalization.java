package com.ensi.ilsi.myClinic.domain;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;



@Entity
@Table(name = "hospitalization")
public class Hospitalization extends AbstractEntity {

    @NotNull
    @Column(name = "startDate", nullable = false)
    private LocalDateTime startDate;

    @NotNull
    @Column(name = "endDate", nullable = false)
    private LocalDateTime endDate ;


    public Hospitalization() {
        // JPA
    }

    public Hospitalization(@NotNull LocalDateTime startDate, @NotNull LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospitalization hospitalization = (Hospitalization) o;
        return Objects.equals(startDate, hospitalization.startDate) &&
                Objects.equals(endDate, hospitalization.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }

    @Override
    public String toString() {
        return "Hospitalization{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate  +
                '}';
    }
}
