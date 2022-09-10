package com.company.client.counter;

import io.restassured.response.Response;

public interface CounterClient {

    String PROCESS = "/";

    Response getMessage();

    Response postSendText(String text);

}
