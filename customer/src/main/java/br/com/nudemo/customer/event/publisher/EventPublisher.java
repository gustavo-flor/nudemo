package br.com.nudemo.customer.event.publisher;

import br.com.nudemo.customer.event.OutputEvent;

public interface EventPublisher {
    void send(final OutputEvent event);
}
