import com.company.dto.CounterDto;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.StringJoiner;

import static org.assertj.core.api.Assertions.assertThat;

public class WordCounterTest extends SpringBaseTest {

    @Test
    public void counterCountingTest() {

        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add(RandomStringUtils.random(10, true, false));
        stringJoiner.add(RandomStringUtils.random(5, true, false));

        String text = stringJoiner.toString();
        CounterDto counterDto = counterServiceInterface.sendText(text);
        assertThat(counterDto.getLines()).isEqualTo(2);
        assertThat(counterDto.getWords()).isEqualTo(2);
        assertThat(counterDto.getCharacters()).isEqualTo(10+5);
    }

    @Test
    public void getHelloWorld() {
        String message = counterServiceInterface.getMessage();

        assertThat(message).isEqualTo("hello world");
    }

}