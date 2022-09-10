package com.company.services;

import com.company.dto.CounterDto;
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
    public CounterDto calculate(String text) {
        if (text == null) {
            throw new RuntimeException("Cannot count lines, words, characters from null Object");
        }

        return CounterDto.builder()
                .lines(countLines(text))
                .words(countWords(text))
                .characters(countCharacters(text))
                .build();
    }
}