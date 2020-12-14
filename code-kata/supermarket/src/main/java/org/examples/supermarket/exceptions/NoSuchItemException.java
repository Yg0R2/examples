package org.examples.supermarket.exceptions;

public class NoSuchItemException extends RuntimeException {

    public NoSuchItemException(String message) {
        super(message);
    }

}
