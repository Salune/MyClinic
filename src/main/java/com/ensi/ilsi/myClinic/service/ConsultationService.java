package com.ensi.ilsi.myClinic.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Supplier;
import static javafx.scene.input.KeyCode.X;

import com.ensi.ilsi.myClinic.domain.Consultation;
import com.ensi.ilsi.myClinic.repository.ConsultationRepository;
import com.ensi.ilsi.myClinic.web.dto.ConsultationDto;

@Service
@Transactional
public class ConsultationService {

    private final Logger log = LoggerFactory.getLogger(ConsultationService.class);

    private final ConsultationRepository consultationRepository;

    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public List<ConsultationDto> findAll() {
        log.debug("Request to get all Consultations");
        return this.consultationRepository.findAll()
                .stream()
                .map(ConsultationService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ConsultationDto findById(Long id) {
        log.debug("Request to get Consultation : {}", id);
        return this.consultationRepository.findById(id).map(ConsultationService::mapToDto)
                .orElseThrow(IllegalStateException::new);
    }

    public ConsultationDto create(ConsultationDto consultationDto) {
        log.debug("Request to create Consultation : {}", consultationDto);
        return mapToDto(this.consultationRepository.save(new Consultation(
                        consultationDto.getStartDate(),
                        consultationDto.getEndDate()
                        
                )
        ));
    }

    public void delete(Long id) {
        log.debug("Request to delete Hopitalization : {}", id);
        this.consultationRepository.deleteById(id);
    }

    public static ConsultationDto mapToDto(Consultation consultation) {
        if (consultation != null) {
            return new ConsultationDto(
                    consultation.getId(),
                    consultation.getStartDate(),
                    consultation.getEndDate()
            );
        }
        return null;
    }

}
