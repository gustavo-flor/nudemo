package br.com.nudemo.customer.exception;

public class CPFAlreadyInUseException extends RuntimeException {
    public CPFAlreadyInUseException() {
        super("CPF already in use");
    }
}
