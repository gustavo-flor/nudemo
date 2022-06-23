package br.com.nudemo.timeline.core.usecase.impl;

import br.com.nudemo.timeline.core.entity.MoneyRescuedMark;
import br.com.nudemo.timeline.core.payload.CreateMoneyRescuedMarkPayload;
import br.com.nudemo.timeline.core.repository.MarkRepository;
import br.com.nudemo.timeline.core.usecase.CreateMoneyRescuedMarkUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Validated
@Component
@RequiredArgsConstructor
public class CreateMoneyRescuedMarkUseCaseImpl implements CreateMoneyRescuedMarkUseCase {
    private final MarkRepository markRepository;

    @Override
    public Mono<MoneyRescuedMark> execute(@Valid CreateMoneyRescuedMarkPayload payload) {
        return markRepository.save(MoneyRescuedMark.of(payload));
    }
}
