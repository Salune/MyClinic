package com.ensi.ilsi.myClinic.domain;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.ensi.ilsi.myClinic.enumeration.PaymentStatus;

import java.util.Objects;


@Entity
@Table(name = "payment")
public class Payment extends AbstractEntity {

    @Column(name = "creditcard_payment_id")
    private String creditcardPaymentId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    
    @NotNull
    @Column(name = "total_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal totalPrice;

    @OneToOne
    @JoinColumn(unique = true)
    private Consultation consultation;

    public Payment() {
        // JPA
    }
   

    public Payment(String creditcardPaymentId, @NotNull PaymentStatus status, BigDecimal totalPrice, Consultation consultation) {
        this.creditcardPaymentId = creditcardPaymentId;
        this.status = status;
        this.totalPrice= totalPrice;
        this.consultation = consultation;
    }

    public String getCreditcardPaymentId() {
        return creditcardPaymentId;
    }

    public void setCreditcardPaymentId(String creditcardPaymentId) {
        this.creditcardPaymentId = creditcardPaymentId;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(creditcardPaymentId, payment.creditcardPaymentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditcardPaymentId);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "creditcardPaymentId='" + creditcardPaymentId + '\'' +
                ", status=" + status +
                ", totalPrice=" + totalPrice +
                ", consultation=" + consultation +
                '}';
    }
    
    
}
