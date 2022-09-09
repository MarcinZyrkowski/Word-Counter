import org.springframework.boot.test.context.SpringBootTest;
import serviceinterface.CounterServiceInterface;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringBaseTest {

    CounterServiceInterface counterServiceInterface = new CounterServiceInterface();

}
