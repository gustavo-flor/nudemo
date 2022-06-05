package br.com.nudemo.customer.entity;

import br.com.nudemo.customer.dto.CreateCustomerDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
@Getter
@Setter
public class Customer {
    @Id
    private String id;

    private String cpf;

    private String name;

    private String email;

    public static Customer of(final CreateCustomerDTO dto) {
        final Customer customer = new Customer();
        customer.setCpf(dto.cpf());
        customer.setName(dto.name());
        customer.setEmail(dto.email());
        return customer;
    }
}
