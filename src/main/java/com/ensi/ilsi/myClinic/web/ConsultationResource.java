/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.myClinic.web;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ensi.ilsi.myClinic.common.Web.API;
import com.ensi.ilsi.myClinic.service.ConsultationService;
import com.ensi.ilsi.myClinic.web.dto.ConsultationDto;


@RestController
@RequestMapping(API + "/consultations")
public class ConsultationResource {

    private final ConsultationService consultationService;

    public ConsultationResource(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @GetMapping
    public List<ConsultationDto> findAll() {
        return this.consultationService.findAll();
    }

    @GetMapping("/{id}")
    public ConsultationDto findById(@PathVariable Long id) {
        return this.consultationService.findById(id);
    }

    @PostMapping
    public ConsultationDto create(ConsultationDto consultationDto) {
        return this.consultationService.create(consultationDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.consultationService.delete(id);
    }
}
