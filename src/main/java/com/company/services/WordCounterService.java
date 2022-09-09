package com.company.services;

import com.company.dto.CounterDto;

public interface WordCounterService {

    Long countLines(String text);

    Long countWords(String text);

    Long countCharacters(String text);

    CounterDto countAllText(String text);

}
