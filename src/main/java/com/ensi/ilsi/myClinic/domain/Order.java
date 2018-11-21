package com.ensi.ilsi.myClinic.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "observation", nullable = false)
    private String observation;

    @NotNull
    @Column(name = "treatment", nullable = false)
    private String treatment;
    
    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    
    public Order() {
        // JPA
    }
   
    public Order(@NotNull String title, @NotNull String observation, @NotNull String treatment,
			@NotNull LocalDateTime date) {
		super();
		this.title = title;
		this.observation = observation;
		this.treatment = treatment;
		this.date = date;
	}

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(treatment, order.treatment) &&
                Objects.equals(observation, order.observation) &&
                Objects.equals(date, order.date) &&
                Objects.equals(title, order.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(treatment, title, date, title);
    }

	@Override
	public String toString() {
		return "Order [title=" + title + ", observation=" + observation + ", treatment=" + treatment + ", date=" + date
				+ "]";
	}

	

	
}
