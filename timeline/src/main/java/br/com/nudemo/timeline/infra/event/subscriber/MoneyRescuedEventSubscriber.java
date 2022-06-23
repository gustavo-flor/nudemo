package br.com.nudemo.timeline.infra.event.subscriber;

import br.com.nudemo.timeline.core.payload.CreateMoneyRescuedMarkPayload;
import br.com.nudemo.timeline.core.usecase.CreateMoneyRescuedMarkUseCase;
import br.com.nudemo.timeline.infra.event.MoneyRescuedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.util.function.Consumer;

@Slf4j
@Component(MoneyRescuedEvent.INPUT_BINDING_NAME)
@RequiredArgsConstructor
public class MoneyRescuedEventSubscriber implements Consumer<MoneyRescuedEvent> {
    private final CreateMoneyRescuedMarkUseCase createMoneyRescuedMarkUseCase;

    @Override
    public void accept(final MoneyRescuedEvent event) {
        final CreateMoneyRescuedMarkPayload payload = CreateMoneyRescuedMarkPayload.builder()
                .cpf(event.cpf())
                .amount(event.amount())
                .occurredAt(event.occurredAt())
                .build();
        try {
            createMoneyRescuedMarkUseCase.execute(payload).subscribe();
        } catch (ConstraintViolationException e) {
            log.error("Constraint violation on create rescued saved mark. event = {}", event, e);
        }
    }
}
