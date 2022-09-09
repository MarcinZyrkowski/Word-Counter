package client.counter;

import client.RestClient;
import io.restassured.response.Response;

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
