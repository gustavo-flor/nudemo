package br.com.nudemo.accountservice.event.publisher;

import br.com.nudemo.accountservice.event.message.OutMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StreamEventPublisher implements EventPublisher {
    private final StreamBridge streamBridge;

    @Override
    public void send(final OutMessage outMessage) {
        streamBridge.send(outMessage.outBindingName(), outMessage);
    }
}
