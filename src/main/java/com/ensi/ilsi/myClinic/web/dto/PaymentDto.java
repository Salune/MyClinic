
package com.ensi.ilsi.myClinic.web.dto;

import java.math.BigDecimal;


public class PaymentDto {
    private Long id;
    private String creditcardPaymentId;
    private String status;
    private BigDecimal totalPrice;
    private Long consultationId;

    public PaymentDto() {
        // JPA
    }

    public PaymentDto(Long id, String creditcardPaymentId, String status,BigDecimal totalPrice, Long consultationId) {
        this.id = id;
        this.creditcardPaymentId = creditcardPaymentId;
        this.status = status;
        this.totalPrice= totalPrice;
        this.consultationId = consultationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditcardPaymentId() {
        return creditcardPaymentId;
    }

    public void setCreditcardPaymentId(String paypalPaymentId) {
        this.creditcardPaymentId = creditcardPaymentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    

    public Long getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Long orderId) {
        this.consultationId = orderId;
    }
}
