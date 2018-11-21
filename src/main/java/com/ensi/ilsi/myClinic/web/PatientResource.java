
package com.ensi.ilsi.myClinic.web;

import com.ensi.ilsi.myClinic.service.PatientService;
import com.ensi.ilsi.myClinic.web.dto.PatientDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ensi.ilsi.myClinic.common.Web.API;


@RestController
@RequestMapping(API + "/patients")
public class PatientResource {

    private final PatientService patientService;

    public PatientResource(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientDto> findAll() {
        return this.patientService.findAll();
    }

    @GetMapping("/{id}")
    public PatientDto findById(@PathVariable Long id) {
        return this.patientService.findById(id);
    }

    @GetMapping("/active")
    public List<PatientDto> findAllActive() {
        return this.patientService.findAllActive();
    }

    @GetMapping("/inactive")
    public List<PatientDto> findAllInactive() {
        return this.patientService.findAllInactive();
    }

    @PostMapping
    public PatientDto create(PatientDto patientDto) {
        return this.patientService.create(patientDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.patientService.delete(id);
    }

}