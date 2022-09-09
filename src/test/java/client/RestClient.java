package client;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class RestClient {

    public static final String baseUrl = "http://localhost";

    public RequestSpecification basicRequestSpecification() {
        return given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON);
    }

    public RequestSpecification basicRequestSpecification(Object pojo) {
        return given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(serializePojo(pojo));
    }

    private String serializePojo(Object pojo) {
        ObjectMapper objectMapper = new ObjectMapper();
        String body = null;
        if (pojo instanceof String) {
            body = (String) pojo;
        } else {
            try {
                body = objectMapper.writeValueAsString(pojo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return body;
    }

}
