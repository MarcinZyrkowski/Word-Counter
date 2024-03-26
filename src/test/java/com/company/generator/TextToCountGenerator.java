package com.company.generator;

import com.company.dto.TextToCountDto;
import java.util.StringJoiner;
import org.apache.commons.lang3.RandomStringUtils;

public class TextToCountGenerator {

    public static TextToCountDto generate() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add(RandomStringUtils.random(10, true, false));
        stringJoiner.add(RandomStringUtils.random(5, true, false));
        String text = stringJoiner.toString();

        return new TextToCountDto(text);
    }

}
