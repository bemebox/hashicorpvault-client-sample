package com.beom.vault.client.service.exception;

/**
 * Thrown when a resource mapping error occurs in the application.
 *
 * @author beom
 * @since: 2023/05/08
 * @see RuntimeException
 */
public class ResourceMapperException extends RuntimeException {

	/**
	 * constructor
	 *
	 * @param msg - the message of the exception
	 */
	public ResourceMapperException(String msg) {
		super(msg);
	}

	/**
	 * constructor
	 *
	 * @param msg - the message of the exception
	 * @param th  - the Throwable exception
	 */
	public ResourceMapperException(String msg, Throwable th) {
		super(msg, th);
	}
}
