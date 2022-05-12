package br.com.nudemo.customerservice.usecase;

import br.com.nudemo.customerservice.dto.CustomerSubscribeDTO;
import br.com.nudemo.customerservice.entity.Customer;
import br.com.nudemo.customerservice.exception.CPFAlreadyInUseException;
import br.com.nudemo.customerservice.exception.EmailAlreadyInUseException;
import br.com.nudemo.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimpleCustomerSubscribeUseCase implements CustomerSubscribeUseCase {
    private final CustomerRepository customerRepository;

    @Override
    public void execute(CustomerSubscribeDTO dto) {
        final Customer customer = Customer.of(dto);
        if (customerRepository.existsByCpf(customer.getCpf())) {
            throw new CPFAlreadyInUseException();
        }
        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new EmailAlreadyInUseException();
        }
        customerRepository.save(customer);
    }
}
