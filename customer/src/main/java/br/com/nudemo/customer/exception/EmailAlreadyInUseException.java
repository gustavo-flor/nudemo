package br.com.nudemo.customer.exception;

public class EmailAlreadyInUseException extends RuntimeException {
    public EmailAlreadyInUseException() {
        super("E-mail already in use");
    }
}
