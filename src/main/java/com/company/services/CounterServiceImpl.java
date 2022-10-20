package com.company.services;

import com.company.dto.CounterResponseDto;
import com.company.dto.TextToCountDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Getter
@Setter
@Service
public class CounterServiceImpl implements WordCounterService {

    private Long countLines(String string) {
        return Stream.of(string.split("\\n")).count();
    }

    private Long countWords(String string) {
        return Stream.of(string
                .split("\\s+")).count();
    }

    private Long countCharacters(String string) {
        return Stream.of(string
                        .replaceAll("[\\n|\\s]", "")
                        .chars()
                        .mapToObj(ch -> (char) ch)
                        .toArray(Character[]::new))
                .count();
    }

    @Override
    public CounterResponseDto calculate(TextToCountDto textToCountDto) {
        if (textToCountDto == null || textToCountDto.getText() == null) {
            throw new RuntimeException("Cannot count lines, words, characters from null Object");
        }

        return CounterResponseDto.builder()
                .lines(countLines(textToCountDto.getText()))
                .words(countWords(textToCountDto.getText()))
                .characters(countCharacters(textToCountDto.getText()))
                .build();
    }
}