package br.com.nudemo.customerservice.exception;

public class OutOfOfficeHourException extends RuntimeException {
    public OutOfOfficeHourException() {
        super("Out of office hour");
    }
}
