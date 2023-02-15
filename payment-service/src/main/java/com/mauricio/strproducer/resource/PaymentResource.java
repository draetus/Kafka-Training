package com.mauricio.strproducer.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mauricio.strproducer.model.Payment;

public interface PaymentResource {
	
	@PostMapping
	ResponseEntity<Payment> payment(@RequestBody Payment payment);

}
