package com.company.tests.counter;

import com.company.dto.CounterResponseDto;
import com.company.dto.TextToCountDto;
import com.company.tests.SpringBaseTestNGTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.util.StringJoiner;

import static org.assertj.core.api.Assertions.assertThat;

public class WordCounterTest extends SpringBaseTestNGTest {

    public static final String HELLO_WORLD_MESSAGE = "hello world";

    @Test
    public void counterCountingTest() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add(RandomStringUtils.random(10, true, false));
        stringJoiner.add(RandomStringUtils.random(5, true, false));
        String text = stringJoiner.toString();

        TextToCountDto textToCountDto = new TextToCountDto(text);

        CounterResponseDto counterResponseDto = counterServiceInterface.sendText(textToCountDto);
        assertThat(counterResponseDto.getLines())
                .as("It should be 2 lines in provided text")
                .isEqualTo(2);
        assertThat(counterResponseDto.getWords())
                .as("It should be 2 words in provided text")
                .isEqualTo(2);
        assertThat(counterResponseDto.getCharacters())
                .as("It should be 15 words in provided text")
                .isEqualTo(10 + 5);
    }

    @Test
    public void getHelloWorld() {
        String message = counterServiceInterface.getMessage();
        assertThat(message).as("Greetings should math the design").isEqualTo(HELLO_WORLD_MESSAGE);
    }

}