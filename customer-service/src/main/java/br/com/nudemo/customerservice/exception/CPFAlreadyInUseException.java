package br.com.nudemo.customerservice.exception;

public class CPFAlreadyInUseException extends RuntimeException {
    public CPFAlreadyInUseException() {
        super("CPF already in use");
    }
}
