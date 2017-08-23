package com.turvo.assesment.shipmenttracking.exception;

public class ShipmentTrackingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1635259480908292100L;

	public ShipmentTrackingException() {
		super();
	}

	public ShipmentTrackingException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ShipmentTrackingException(String message, Throwable cause) {
		super(message, cause);
	}

	public ShipmentTrackingException(String message) {
		super(message);
	}

	public ShipmentTrackingException(Throwable cause) {
		super(cause);
	}

}
