package com.company.services;

import com.company.dto.CounterResponseDto;
import com.company.dto.TextToCountDto;

public interface WordCounterService {

    CounterResponseDto calculate(TextToCountDto textToCountDto);

}
