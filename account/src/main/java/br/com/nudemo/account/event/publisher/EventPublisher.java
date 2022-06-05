package br.com.nudemo.account.event.publisher;

import br.com.nudemo.account.event.OutputEvent;

public interface EventPublisher {
    void send(final OutputEvent event);
}
