package br.com.nudemo.accountservice.exception;

public class CustomerAlreadyHasAnAccountException extends RuntimeException {
    public CustomerAlreadyHasAnAccountException() {
        super("Customer already has an account");
    }
}
