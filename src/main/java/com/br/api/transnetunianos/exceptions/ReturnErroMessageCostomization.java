package com.br.api.transnetunianos.exceptions;

public class ReturnErroMessageCostomization extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ReturnErroMessageCostomization(String msg) {
		super(String.format(msg));
 	}
}
