package br.com.nudemo.account.exception;

public class CPFAlreadyInUseException extends RuntimeException {
    public CPFAlreadyInUseException() {
        super("CPF already in use");
    }
}
