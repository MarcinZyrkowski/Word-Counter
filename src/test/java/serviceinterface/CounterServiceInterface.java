package serviceinterface;

import client.counter.CounterRestClient;
import com.company.dto.CounterDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class CounterServiceInterface {

    CounterRestClient counterRestClient = new CounterRestClient();
    ObjectMapper objectMapper = new ObjectMapper();

    public String getMessage() {
        return counterRestClient.getMessage().body().asString();
    }

    @SneakyThrows
    public CounterDto sendText(String text) {
        var response = counterRestClient.postSendText(text);
        return objectMapper.readValue(response.body().asString(), CounterDto.class);
    }

}
