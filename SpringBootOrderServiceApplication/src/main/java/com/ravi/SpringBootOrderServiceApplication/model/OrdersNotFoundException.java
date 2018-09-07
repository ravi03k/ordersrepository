package com.ravi.SpringBootOrderServiceApplication.model;
public class OrdersNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1855116107680957533L;

	public OrdersNotFoundException(String exception) {
		super(exception);
	}

}