package br.com.nudemo.customer.dto;

import br.com.nudemo.customer.util.StringUtil;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record SubscribeCustomerDTO(@CPF @NotBlank String cpf,
                                   @NotBlank String name,
                                   @Email @NotBlank String email) {
    @Override
    public String cpf() {
        return StringUtil.getOnlyDigits(cpf);
    }
}
