package com.company.serviceinterface;

import static org.assertj.core.api.Assertions.assertThat;

import com.company.client.counter.CounterRestClient;
import com.company.dto.CounterResponseDto;
import com.company.dto.TextToCountDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CounterServiceInterface {

    private final CounterRestClient counterRestClient;
    private final ObjectMapper objectMapper;

    @Step("Get message")
    public String getMessage() {
        Response response = counterRestClient.getMessage();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK.value());
        return response.body().asString();
    }

    @SneakyThrows
    @Step("Send text: {textToCountDto.text}")
    public CounterResponseDto sendText(TextToCountDto textToCountDto) {
        Response response = counterRestClient.postSendText(textToCountDto);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK.value());
        return objectMapper.readValue(response.body().asString(), CounterResponseDto.class);
    }

}
