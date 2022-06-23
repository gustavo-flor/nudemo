package br.com.nudemo.timeline.core.usecase.impl;

import br.com.nudemo.timeline.core.entity.MoneySavedMark;
import br.com.nudemo.timeline.core.payload.CreateMoneySavedMarkPayload;
import br.com.nudemo.timeline.core.repository.MarkRepository;
import br.com.nudemo.timeline.core.usecase.CreateMoneySavedMarkUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Validated
@Component
@RequiredArgsConstructor
public class CreateMoneySavedMarkUseCaseImpl implements CreateMoneySavedMarkUseCase {
    private final MarkRepository markRepository;

    @Override
    public Mono<MoneySavedMark> execute(@Valid CreateMoneySavedMarkPayload payload) {
        return markRepository.save(MoneySavedMark.of(payload));
    }
}
