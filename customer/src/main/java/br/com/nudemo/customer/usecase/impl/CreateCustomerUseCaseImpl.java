package br.com.nudemo.customer.usecase.impl;

import br.com.nudemo.customer.dto.CreateCustomerDTO;
import br.com.nudemo.customer.dto.CustomerDTO;
import br.com.nudemo.customer.entity.Customer;
import br.com.nudemo.customer.event.CustomerCreatedEvent;
import br.com.nudemo.customer.event.publisher.EventPublisher;
import br.com.nudemo.customer.exception.CPFAlreadyInUseException;
import br.com.nudemo.customer.exception.EmailAlreadyInUseException;
import br.com.nudemo.customer.repository.CustomerRepository;
import br.com.nudemo.customer.usecase.CreateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {
    private final CustomerRepository customerRepository;
    private final EventPublisher eventPublisher;

    @Override
    public CustomerDTO execute(final CreateCustomerDTO dto) {
        if (customerRepository.existsByCpf(dto.cpf())) {
            throw new CPFAlreadyInUseException();
        }
        if (customerRepository.existsByEmail(dto.email())) {
            throw new EmailAlreadyInUseException();
        }
        final Customer customer = customerRepository.save(Customer.of(dto));
        eventPublisher.send(CustomerCreatedEvent.of(customer));
        return CustomerDTO.of(customer);
    }
}
