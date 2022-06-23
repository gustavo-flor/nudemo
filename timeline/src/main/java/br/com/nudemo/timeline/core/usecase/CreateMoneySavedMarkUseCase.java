package br.com.nudemo.timeline.core.usecase;

import br.com.nudemo.timeline.core.entity.MoneySavedMark;
import br.com.nudemo.timeline.core.payload.CreateMoneySavedMarkPayload;
import reactor.core.publisher.Mono;

public interface CreateMoneySavedMarkUseCase {
    Mono<MoneySavedMark> execute(CreateMoneySavedMarkPayload payload);
}
