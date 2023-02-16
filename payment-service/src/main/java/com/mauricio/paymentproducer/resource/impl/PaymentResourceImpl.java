package com.mauricio.paymentproducer.resource.impl;

import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mauricio.paymentproducer.model.Payment;
import com.mauricio.paymentproducer.resource.PaymentResource;
import com.mauricio.paymentproducer.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/payments")
public class PaymentResourceImpl implements PaymentResource {
	
	private final PaymentService paymentService;

	@Override
	public ResponseEntity<Payment> payment(Payment payment) {
		paymentService.sendPayment(payment);
		return ResponseEntity.status(CREATED).build();
	}

}
