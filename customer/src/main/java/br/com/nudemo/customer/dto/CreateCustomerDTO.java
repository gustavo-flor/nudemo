package br.com.nudemo.customer.dto;

import lombok.Builder;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Builder
public record CreateCustomerDTO(@CPF @NotBlank String cpf,
                                @NotBlank String name,
                                @Email @NotBlank String email) {
}
