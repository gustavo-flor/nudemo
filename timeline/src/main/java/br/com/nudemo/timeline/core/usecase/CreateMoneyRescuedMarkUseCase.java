package br.com.nudemo.timeline.core.usecase;

import br.com.nudemo.timeline.core.entity.MoneyRescuedMark;
import br.com.nudemo.timeline.core.payload.CreateMoneyRescuedMarkPayload;
import reactor.core.publisher.Mono;

public interface CreateMoneyRescuedMarkUseCase {
    Mono<MoneyRescuedMark> execute(CreateMoneyRescuedMarkPayload payload);
}
