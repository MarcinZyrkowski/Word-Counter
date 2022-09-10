package com.company.serviceinterface;

import com.company.client.counter.CounterRestClient;
import com.company.dto.CounterDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CounterServiceInterface {

    private final CounterRestClient counterRestClient;
    private final ObjectMapper objectMapper;

    public String getMessage() {
        return counterRestClient.getMessage().body().asString();
    }

    @SneakyThrows
    public CounterDto sendText(String text) {
        var response = counterRestClient.postSendText(text);
        return objectMapper.readValue(response.body().asString(), CounterDto.class);
    }

}
