package com.company.tests.counter;

import com.company.dto.CounterResponseDto;
import com.company.dto.TextToCountDto;
import com.company.tests.SpringBaseTestNGTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import java.util.StringJoiner;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Word counter: counting feature and get feature")
@Story("Word counter test")
@DisplayName("REST: Word counter test")
public class WordCounterTest extends SpringBaseTestNGTest {
    public static final String HELLO_WORLD_MESSAGE = "hello world";

    @Test
    @Description("Verify counting feature")
    @DisplayName("Verify counting feature")
    public void verifyCountingFeature() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add(RandomStringUtils.random(10, true, false));
        stringJoiner.add(RandomStringUtils.random(5, true, false));
        String text = stringJoiner.toString();

        TextToCountDto textToCountDto = new TextToCountDto(text);

        CounterResponseDto counterResponseDto = counterServiceInterface
                .sendText(textToCountDto);
        assertThat(counterResponseDto.getLines())
                .withFailMessage("It should be 2 lines in provided text")
                .isEqualTo(2);
        assertThat(counterResponseDto.getWords())
                .withFailMessage("It should be 2 words in provided text")
                .isEqualTo(2);
        assertThat(counterResponseDto.getCharacters())
                .withFailMessage("It should be 15 words in provided text")
                .isEqualTo(10 + 5);
    }

    @Test
    @Description("Verify get hello world")
    @DisplayName("Verify get hello world")
    public void getHelloWorld() {
        String message = counterServiceInterface.getMessage();
        assertThat(message)
                .withFailMessage("Greetings should math the design")
                .isEqualTo(HELLO_WORLD_MESSAGE);
    }

}