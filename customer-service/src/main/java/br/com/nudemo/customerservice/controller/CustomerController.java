package br.com.nudemo.customerservice.controller;

import br.com.nudemo.customerservice.dto.CustomerSubscribeDTO;
import br.com.nudemo.customerservice.usecase.CustomerSubscribeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerSubscribeUseCase customerSubscribeUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void subscribe(@Valid @RequestBody CustomerSubscribeDTO dto) {
        customerSubscribeUseCase.execute(dto);
    }
}
