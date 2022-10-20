package com.company.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CounterResponseDto {

    @JsonProperty("numberOfLines")
    private long lines;

    @JsonProperty("numberOfWords")
    private long words;

    @JsonProperty("numberOfCharacters")
    private long characters;

}
