package br.com.nudemo.customer.event;

import br.com.nudemo.customer.dto.SubscribeCustomerDTO;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public record CustomerSubscribedEvent(String cpf, String name, String email) implements OutputEvent {
    public static final String INPUT_BINDING_NAME = "customerSubscribed-event";

    @Override
    public String outputBindingName() {
        return "customerSubscribed-event-out-0";
    }

    @Override
    public Message<? extends OutputEvent> message() {
        return MessageBuilder.withPayload(this)
                .setHeader(OutputEvent.PARTITION_KEY_HEADER_NAME, cpf())
                .build();
    }

    public static CustomerSubscribedEvent of(final SubscribeCustomerDTO dto) {
        return new CustomerSubscribedEvent(dto.cpf(), dto.name(), dto.email());
    }
}
