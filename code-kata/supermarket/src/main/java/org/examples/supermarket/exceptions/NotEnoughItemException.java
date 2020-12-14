package org.examples.supermarket.exceptions;

public class NotEnoughItemException extends RuntimeException {

    public NotEnoughItemException(String message) {
        super(message);
    }

}
