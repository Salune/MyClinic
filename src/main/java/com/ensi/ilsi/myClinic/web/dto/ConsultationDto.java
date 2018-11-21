/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.myClinic.web.dto;

import java.time.LocalDateTime;


public class ConsultationDto {
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public LocalDateTime getEndDate() {
		return endDate;
	}

	

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}



	public ConsultationDto() {
        // JACKSON
    }

    public ConsultationDto(Long id, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    
}
