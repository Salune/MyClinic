
package com.ensi.ilsi.myClinic.web;

import com.ensi.ilsi.myClinic.service.PaymentService;
import com.ensi.ilsi.myClinic.web.dto.PaymentDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ensi.ilsi.myClinic.common.Web.API;


@RestController
@RequestMapping(API + "/payments")
public class PaymentResource {

    private final PaymentService paymentService;

    public PaymentResource(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping()
    public List<PaymentDto> findAll() {
        return this.paymentService.findAll();
    }

    @GetMapping("/{id}")
    public PaymentDto findById(@PathVariable Long id) {
        return this.paymentService.findById(id);
    }

    @PostMapping()
    public PaymentDto create(@RequestBody PaymentDto consultationDto) {
        return this.paymentService.create(consultationDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.paymentService.delete(id);
    }
}
