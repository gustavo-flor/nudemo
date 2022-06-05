package br.com.nudemo.account.event.publisher.impl;

import br.com.nudemo.account.event.OutputEvent;
import br.com.nudemo.account.event.publisher.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventPublisherImpl implements EventPublisher {
    private final StreamBridge streamBridge;

    @Override
    public void send(final OutputEvent event) {
        streamBridge.send(event.outputBindingName(), event.message());
    }
}
