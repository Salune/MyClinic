/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.myClinic.web;

import com.ensi.ilsi.myClinic.service.OrderService;
import com.ensi.ilsi.myClinic.web.dto.OrderDto;

import org.springframework.web.bind.annotation.*;

import static com.ensi.ilsi.myClinic.common.Web.API;

import java.util.List;


@RestController
@RequestMapping(API + "/orders")
public class OrderResource {

    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDto> findAll() {
        return this.orderService.findAll();
    }

    @GetMapping("/orders")
    public List<OrderDto> findAllByUser(@PathVariable Long id) {
        return this.orderService.findAll();
    }

    @GetMapping("/{id}")
    public OrderDto findById(@PathVariable Long id) {
        return this.orderService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.orderService.delete(id);
    }
}
