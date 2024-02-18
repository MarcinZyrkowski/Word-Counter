package com.company.assertions;

import com.company.dto.CounterResponseDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CounterAssertions {

  private CounterResponseDto counterResponseDto;

  public static CounterAssertions assertThat(CounterResponseDto counterResponseDto) {
    return new CounterAssertions(counterResponseDto);
  }

  public CounterAssertions verifyLinesNumber(long expectedLines) {
    Assertions.assertThat(counterResponseDto.getLines())
          .withFailMessage(String.format("It should be %d lines in provided text", expectedLines))
            .isEqualTo(expectedLines);
    return this;
  }

  public CounterAssertions verifyWordsNumber(long expectedWords) {
    Assertions.assertThat(counterResponseDto.getWords())
        .withFailMessage(String.format("It should be %d words in provided text", expectedWords))
        .isEqualTo(expectedWords);
    return this;
  }

  public CounterAssertions verifyCharactersNumber(long expectedCharacters) {
    Assertions.assertThat(counterResponseDto.getCharacters())
        .withFailMessage(String.format("It should be %d characters in provided text", expectedCharacters))
        .isEqualTo(expectedCharacters);
    return this;
  }
}
