package com.shumz.tconverter;

public class InvalidTemperatureException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8753558924362841725L;

	public InvalidTemperatureException(String msg) {
		super(msg);
	}
}