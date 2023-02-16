package com.mauricio.jsonconsumer.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Payment implements Serializable {
	
	private static final long serialVersionUID = 5136052227065039229L;

	private Long id;
	
	private Long idUser;
	
	private Long idProduct;
	
	private String cardNumber;

}
