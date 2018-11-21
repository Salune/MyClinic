package com.ensi.ilsi.myClinic.service;

import com.ensi.ilsi.myClinic.domain.Hospitalization;
import com.ensi.ilsi.myClinic.web.dto.HospitalizationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import com.ensi.ilsi.myClinic.repository.HospitalizationRepository;

@Service
@Transactional
public class HospitalizationService {

    private final Logger log = LoggerFactory.getLogger(HospitalizationService.class);

    private final HospitalizationRepository hospitalizationRepository;

    public HospitalizationService(HospitalizationRepository hospitalizationRepository) {
        this.hospitalizationRepository = hospitalizationRepository;
    }

    public List<HospitalizationDto> findAll() {
        log.debug("Request to get all Hospitalizations");
        return this.hospitalizationRepository.findAll()
                .stream()
                .map(HospitalizationService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public HospitalizationDto findById(Long id) {
        log.debug("Request to get Hospitalization : {}", id);
        return this.hospitalizationRepository.findById(id).map(HospitalizationService::mapToDto)
                .orElseThrow(IllegalStateException::new);
    }

    public HospitalizationDto create(HospitalizationDto hospitalizationDto) {
        log.debug("Request to create Hopitalization : {}", hospitalizationDto);
        return mapToDto(this.hospitalizationRepository.save(new Hospitalization(
                        hospitalizationDto.getStartDate(),
                        hospitalizationDto.getEndDate()
                        
                )
        ));
    }

    public void delete(Long id) {
        log.debug("Request to delete Hopitalization : {}", id);
        this.hospitalizationRepository.deleteById(id);
    }

    public static HospitalizationDto mapToDto(Hospitalization hospitalization) {
        if (hospitalization != null) {
            return new HospitalizationDto(
                    hospitalization.getId(),
                    hospitalization.getStartDate(),
                    hospitalization.getEndDate()
            );
        }
        return null;
    }

}
