package br.com.nudemo.customerservice.controller.advice;

import br.com.nudemo.customerservice.exception.CPFAlreadyInUseException;
import br.com.nudemo.customerservice.exception.EmailAlreadyInUseException;
import br.com.nudemo.customerservice.exception.OutOfOfficeHourException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(CPFAlreadyInUseException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Message handleCPFAlreadyInUseException(CPFAlreadyInUseException exception,
                                                  HttpServletRequest httpServletRequest) {
        return Message.conflict(exception.getMessage(), httpServletRequest.getRequestURI());
    }

    @ExceptionHandler(EmailAlreadyInUseException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Message handleEmailAlreadyInUseException(EmailAlreadyInUseException exception,
                                                    HttpServletRequest httpServletRequest) {
        return Message.conflict(exception.getMessage(), httpServletRequest.getRequestURI());
    }

    private record Message(LocalDateTime timestamp, Integer status, String error, String path) {
        private static Message of(final HttpStatus httpStatus, final String error, final String path) {
            return new Message(LocalDateTime.now(), httpStatus.value(), error, path);
        }

        public static Message conflict(final String error, final String path) {
            return Message.of(HttpStatus.CONFLICT, error, path);
        }

        public static Message serviceUnavailable(final String error, final String path) {
            return Message.of(HttpStatus.SERVICE_UNAVAILABLE, error, path);
        }
    }
}
