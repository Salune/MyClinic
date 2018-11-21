package com.ensi.ilsi.myClinic.service;

import com.ensi.ilsi.myClinic.domain.Consultation;
import com.ensi.ilsi.myClinic.domain.Payment;
import com.ensi.ilsi.myClinic.enumeration.PaymentStatus;
import com.ensi.ilsi.myClinic.repository.ConsultationRepository;
import com.ensi.ilsi.myClinic.repository.PaymentRepository;
import com.ensi.ilsi.myClinic.web.dto.PaymentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PaymentService {
    private final Logger log = LoggerFactory.getLogger(PaymentService.class);

    private final PaymentRepository paymentRepository;
    private final ConsultationRepository consultationRepository;

    public PaymentService(PaymentRepository paymentRepository, ConsultationRepository consultationRepository) {
        this.paymentRepository = paymentRepository;
        this.consultationRepository = consultationRepository;
    }

    public List<PaymentDto> findAll() {
        log.debug("Request to get all Payments");
        return this.paymentRepository.findAll()
                .stream()
                .map(PaymentService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PaymentDto findById(Long id) {
        log.debug("Request to get Payment : {}", id);
        return this.paymentRepository.findById(id).map(PaymentService::mapToDto).orElse(null);
    }

    public PaymentDto create(PaymentDto paymentDto) {
        log.debug("Request to create Payment : {}", paymentDto);

        Consultation consultation = this.consultationRepository.findById(paymentDto.getConsultationId()).orElseThrow(() -> new IllegalStateException("The Consultation does not exist!"));

        return mapToDto(this.paymentRepository.save(
                new Payment(
                        paymentDto.getCreditcardPaymentId(),
                        PaymentStatus.valueOf(paymentDto.getStatus()),
                        paymentDto.getTotalPrice(),
                        consultation
                )
        ));
    }

    public void delete(Long id) {
        log.debug("Request to delete Payment : {}", id);
        this.paymentRepository.deleteById(id);
    }

    public static PaymentDto mapToDto(Payment payment) {
        if (payment != null) {
            return new PaymentDto(
                    payment.getId(),
                    payment.getCreditcardPaymentId(),
                    payment.getStatus().name(),
                    payment.getTotalPrice(),
                    payment.getConsultation().getId()
            );
        }
        return null;
    }
}