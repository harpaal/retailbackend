package com.retail.exception;

public class ShopNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1985334148062023694L;
	
	public ShopNotFoundException(String message, Throwable cause) {
        super(message, cause);
      
	}
}
