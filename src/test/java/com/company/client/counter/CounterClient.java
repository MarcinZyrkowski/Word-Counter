package com.company.client.counter;

import com.company.dto.TextToCountDto;
import io.restassured.response.Response;

public interface CounterClient {

    String PROCESS = "/";

    Response getMessage();

    Response postSendText(TextToCountDto textToCountDto);

}
