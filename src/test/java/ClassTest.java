import com.company.dto.CounterDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ClassTest {

    public static final String baseUrl = "http://localhost";

    @Test
    public void counterCountingTest() throws JsonProcessingException {

        String text = "xxx\noo\nii tt";
        ObjectMapper objectMapper = new ObjectMapper();

        Response response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(text)
                .post("/");

        CounterDto counterDto = objectMapper.readValue(response.body().asString(), CounterDto.class);
        assertThat(counterDto.getLines()).isEqualTo(3);
        assertThat(counterDto.getWords()).isEqualTo(4);
        assertThat(counterDto.getCharacters()).isEqualTo(9);
    }

    @Test
    public void getHelloWorld() {
        Response response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .get("/");

        assertThat(response.body().asString()).isEqualTo("hello world");
    }

}