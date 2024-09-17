package com.beom.vault.client.service.exception;

/**
 * Thrown when no data key found error occurs in the application.
 *
 * @author beom
 * @since 2024/09/17
 * @see RuntimeException
 */
public class NoDataKeyFoundException extends RuntimeException {

    /**
     * constructor
     *
     * @param msg - the message of the exception
     */
    public NoDataKeyFoundException(String msg) {
        super(msg);
    }

    /**
     * constructor
     *
     * @param msg - the message of the exception
     * @param th  - the Throwable exception
     */
    public NoDataKeyFoundException(String msg, Throwable th) {
        super(msg, th);
    }
}
