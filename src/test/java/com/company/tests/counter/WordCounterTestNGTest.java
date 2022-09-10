package com.company.tests.counter;

import com.company.dto.CounterDto;
import com.company.tests.SpringBaseTestNGTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import java.util.StringJoiner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class WordCounterTestNGTest extends SpringBaseTestNGTest {

    public static final String HELLO_WORLD_MESSAGE = "hello world";

    @Test
    public void counterCountingTest() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add(RandomStringUtils.random(10, true, false));
        stringJoiner.add(RandomStringUtils.random(5, true, false));
        String text = stringJoiner.toString();
        text = null;

        CounterDto counterDto = counterServiceInterface.sendText(text);
        assertThat(counterDto.getLines()).isEqualTo(2);
        assertThat(counterDto.getWords()).isEqualTo(2);
        assertThat(counterDto.getCharacters()).isEqualTo(10 + 5);
    }

    @Test
    public void getHelloWorld() {
        String message = counterServiceInterface.getMessage();
        assertThat(message).isEqualTo(HELLO_WORLD_MESSAGE);
    }

}