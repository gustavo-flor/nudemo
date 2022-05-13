package br.com.nudemo.accountservice.event.publisher;

import br.com.nudemo.accountservice.event.message.OutMessage;

public interface EventPublisher {
    void send(final OutMessage outMessage);
}
