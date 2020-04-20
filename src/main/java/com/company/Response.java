package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response {

    @JsonProperty("numberOfLines")
    private long lines;

    @JsonProperty("numberOfWords")
    private long words;

    @JsonProperty("numberOfCharacters")
    private long characters;

}
