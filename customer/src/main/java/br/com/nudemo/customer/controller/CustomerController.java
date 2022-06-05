package br.com.nudemo.customer.controller;

import br.com.nudemo.customer.dto.CustomerDTO;
import br.com.nudemo.customer.dto.SubscribeCustomerDTO;
import br.com.nudemo.customer.usecase.FindCustomerByIdUseCase;
import br.com.nudemo.customer.usecase.SubscribeCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final SubscribeCustomerUseCase subscribeCustomerUseCase;
    private final FindCustomerByIdUseCase findCustomerByIdUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void subscribe(@Valid @RequestBody final SubscribeCustomerDTO dto) {
        subscribeCustomerUseCase.execute(dto);
    }

    @GetMapping("/{id}")
    public CustomerDTO findById(@PathVariable final String id) {
        return findCustomerByIdUseCase.execute(id);
    }
}
