package br.com.nudemo.customerservice.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record CustomerSubscribeDTO(@CPF @NotBlank String cpf,
                                   @NotBlank String name,
                                   @Email @NotBlank String email) {
}
