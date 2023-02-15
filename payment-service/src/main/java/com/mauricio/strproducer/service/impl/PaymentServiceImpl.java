package com.mauricio.strproducer.service.impl;

import org.springframework.stereotype.Service;

import com.mauricio.strproducer.model.Payment;
import com.mauricio.strproducer.service.PaymentService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {

	@Override
	public void sendPayment(Payment payment) {
		log.info("PAYMENT_SERVICE_IMPL ::: Recebi o pagamento {} ", payment);
	}

}
