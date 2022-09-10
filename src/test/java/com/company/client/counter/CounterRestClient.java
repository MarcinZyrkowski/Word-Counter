package com.company.client.counter;

import com.company.client.RestClient;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

@Component
public class CounterRestClient extends RestClient implements CounterClient {

    @Override
    public Response getMessage() {
        return basicRequestSpecification()
                .get(PROCESS);
    }

    @Override
    public Response postSendText(String text) {
        return basicRequestSpecification(text)
                .post(PROCESS);
    }
}
