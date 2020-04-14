package com.company;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Getter
@Setter
@Component
public class Counter implements WordCounter {


    @Override
    public long countLines(String string) {
        return Stream.of(string.split("\\n")).count();
    }

    @Override
    public long countWords(String string) {
        return Stream.of(string
                .split("\\s+")).count();
    }

    @Override
    public long countCharacters(String string) {
        return Stream.of(string
                .replaceAll("[\\n|\\s]", "")
                .chars()
                .mapToObj(ch -> (char) ch)
                .toArray(Character[]::new))
                .count();
    }

}