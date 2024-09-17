package com.beom.vault.client.service.exception;

/**
 * Thrown when no secrets found error occurs in the application.
 *
 * @author beom
 * @since 2024/09/17
 * @see RuntimeException
 */
public class NoSecretsFoundException extends RuntimeException {

	/**
	 * constructor
	 *
	 * @param msg - the message of the exception
	 */
	public NoSecretsFoundException(String msg) {
		super(msg);
	}

	/**
	 * constructor
	 *
	 * @param msg - the message of the exception
	 * @param th  - the Throwable exception
	 */
	public NoSecretsFoundException(String msg, Throwable th) {
		super(msg, th);
	}
}
