package br.com.nudemo.customerservice.exception;

public class EmailAlreadyInUseException extends RuntimeException {
    public EmailAlreadyInUseException() {
        super("E-mail already in use");
    }
}
