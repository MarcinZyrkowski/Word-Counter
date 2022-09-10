package com.company.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Environment {

    BASE_URL("http://localhost");

    private final String url;

}
