package br.com.nudemo.customer.event;

import br.com.nudemo.customer.entity.Customer;
import lombok.Builder;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@Builder
public record CustomerCreatedEvent(String id, String cpf, String name, String email) implements OutputEvent {
    @Override
    public String outputBindingName() {
        return "customerCreated-event-out-0";
    }

    @Override
    public Message<? extends OutputEvent> message() {
        return MessageBuilder.withPayload(this).build();
    }

    public static CustomerCreatedEvent of(final Customer customer) {
        return CustomerCreatedEvent.builder()
                .id(customer.getId())
                .cpf(customer.getCpf())
                .name(customer.getName())
                .email(customer.getEmail())
                .build();
    }
}
