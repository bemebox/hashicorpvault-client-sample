package com.beom.vault.client.service.exception;

/**
 * Thrown when no data found error occurs in the application.
 *
 * @author beom
 * @since 2024/09/17
 * @see RuntimeException
 */
public class NoDataFoundException extends RuntimeException {

    /**
     * constructor
     *
     * @param msg - the message of the exception
     */
    public NoDataFoundException(String msg) {
        super(msg);
    }

    /**
     * constructor
     *
     * @param msg - the message of the exception
     * @param th  - the Throwable exception
     */
    public NoDataFoundException(String msg, Throwable th) {
        super(msg, th);
    }
}
