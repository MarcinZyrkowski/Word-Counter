package com.company.services;

import com.company.dto.CounterDto;

public interface WordCounterService {

    CounterDto calculate(String text);

}
