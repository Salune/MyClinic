/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.myClinic.web.dto;

import java.time.LocalDateTime;

/**
 *
 * @author n.lamouchi
 */
public class OrderDto {
    private Long id;
    private String observation;
    private String title;
    private String treatment;
    private LocalDateTime date;

    public OrderDto() {
        // JACKSON
    }

    
    public OrderDto(Long id, String observation, String title, String treatment,LocalDateTime date) {
		super();
		this.id = id;
		this.observation = observation;
		this.title = title;
		this.treatment = treatment;
		this.date=date;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getTreatment() {
		return treatment;
	}


	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}


	
}
