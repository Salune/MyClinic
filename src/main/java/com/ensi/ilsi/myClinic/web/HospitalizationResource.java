/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.myClinic.web;

import com.ensi.ilsi.myClinic.service.HospitalizationService;
import com.ensi.ilsi.myClinic.web.dto.HospitalizationDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ensi.ilsi.myClinic.common.Web.API;


@RestController
@RequestMapping(API + "/hospitalizations")
public class HospitalizationResource {

    private final HospitalizationService hospitalizationService;

    public HospitalizationResource(HospitalizationService hospitalizationService) {
        this.hospitalizationService = hospitalizationService;
    }

    @GetMapping
    public List<HospitalizationDto> findAll() {
        return this.hospitalizationService.findAll();
    }

    @GetMapping("/{id}")
    public HospitalizationDto findById(@PathVariable Long id) {
        return this.hospitalizationService.findById(id);
    }

    @PostMapping
    public HospitalizationDto create(HospitalizationDto hospitalizationDto) {
        return this.hospitalizationService.create(hospitalizationDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.hospitalizationService.delete(id);
    }
}
