package com.company.tests.counter;

import com.company.assertions.CounterAssertions;
import com.company.dto.CounterResponseDto;
import com.company.dto.TextToCountDto;
import com.company.generator.TextToCountGenerator;
import com.company.tests.SpringBaseTestNGTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Story("Word counter test")
@Feature("Word counter: counting feature and get feature")
public class WordCounterTest extends SpringBaseTestNGTest {
  public static final String HELLO_WORLD_MESSAGE = "hello world";

  @Test(description = "Verify counting feature")
  @Description("Verify counting feature")
  public void verifyCountingFeature() {
    // given
    TextToCountDto payload = TextToCountGenerator.generate();

    // when
    CounterResponseDto response = counterServiceInterface
        .sendText(payload);

    // then
    CounterAssertions.assertThat(response)
        .hasLinesNumber(2)
        .hasWordsNumber(2)
        .hasCharactersNumber(15);
  }

  @Test(description = "Verify get hello world")
  @Description("Verify get hello world")
  public void getHelloWorld() {
    String message = counterServiceInterface.getMessage();

    assertThat(message)
        .withFailMessage("Greetings should math the design")
        .isEqualTo(HELLO_WORLD_MESSAGE);
  }

}