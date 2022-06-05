package br.com.nudemo.customer.usecase.impl;

import br.com.nudemo.customer.dto.CustomerDTO;
import br.com.nudemo.customer.exception.NotFoundException;
import br.com.nudemo.customer.repository.CustomerRepository;
import br.com.nudemo.customer.usecase.FindCustomerByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {
    private final CustomerRepository customerRepository;

    @Override
    public CustomerDTO execute(final String id) {
        return customerRepository.findById(id)
                .map(CustomerDTO::of)
                .orElseThrow(NotFoundException::new);
    }
}
