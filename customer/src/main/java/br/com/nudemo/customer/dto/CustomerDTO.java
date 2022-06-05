package br.com.nudemo.customer.dto;

import br.com.nudemo.customer.entity.Customer;
import lombok.Builder;

@Builder
public record CustomerDTO(String id, String cpf, String name, String email) {
    public static CustomerDTO of(final Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .cpf(customer.getCpf())
                .name(customer.getName())
                .email(customer.getEmail())
                .build();
    }
}
