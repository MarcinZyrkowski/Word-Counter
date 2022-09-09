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

    @Override
    public Long countLines(String string) {
        return Stream.of(string.split("\\n")).count();
    }

    @Override
    public Long countWords(String string) {
        return Stream.of(string
                .split("\\s+")).count();
    }

    @Override
    public Long countCharacters(String string) {
        return Stream.of(string
                        .replaceAll("[\\n|\\s]", "")
                        .chars()
                        .mapToObj(ch -> (char) ch)
                        .toArray(Character[]::new))
                .count();
    }

    @Override
    public CounterDto countAllText(String text) {
        return CounterDto.builder()
                .lines(countLines(text))
                .words(countWords(text))
                .characters(countCharacters(text))
                .build();
    }

}