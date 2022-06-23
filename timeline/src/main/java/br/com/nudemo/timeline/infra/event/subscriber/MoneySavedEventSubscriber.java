package br.com.nudemo.timeline.infra.event.subscriber;

import br.com.nudemo.timeline.core.payload.CreateMoneySavedMarkPayload;
import br.com.nudemo.timeline.core.usecase.CreateMoneySavedMarkUseCase;
import br.com.nudemo.timeline.infra.event.MoneySavedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.util.function.Consumer;

@Slf4j
@Component(MoneySavedEvent.INPUT_BINDING_NAME)
@RequiredArgsConstructor
public class MoneySavedEventSubscriber implements Consumer<MoneySavedEvent> {
    private final CreateMoneySavedMarkUseCase createMoneySavedMarkUseCase;

    @Override
    public void accept(final MoneySavedEvent event) {
        log.info("Received event to create money saved mark. event = {}", event);
        final CreateMoneySavedMarkPayload payload = CreateMoneySavedMarkPayload.builder()
                .cpf(event.cpf())
                .amount(event.amount())
                .occurredAt(event.occurredAt())
                .build();
        try {
            createMoneySavedMarkUseCase.execute(payload).subscribe();
        } catch (ConstraintViolationException e) {
            log.error("Constraint violation on create money saved mark. event = {}", event, e);
        }
    }
}
