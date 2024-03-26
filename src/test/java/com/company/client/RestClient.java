package com.company.client;

import static io.restassured.RestAssured.given;

import com.company.config.Environment;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import java.util.Objects;
import lombok.SneakyThrows;

public abstract class RestClient {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public RequestSpecification basicRequestSpecification() {
        return given()
            .baseUri(Environment.BASE_URL.getUrl())
            .contentType(ContentType.JSON)
            .filter(new AllureRestAssured())
            .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public RequestSpecification basicRequestSpecification(Object pojo) {
        return basicRequestSpecification()
            .body(serializePojo(pojo));
    }

    @SneakyThrows
    private String serializePojo(Object pojo) {
        Objects.requireNonNull(pojo, "Null POJO provided");
        return OBJECT_MAPPER.writeValueAsString(pojo);
    }

}
