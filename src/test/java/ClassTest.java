import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class ClassTest {

    @Test
    public void ExistsAndNotEmpty(){

        try {
            File file = new File("try.txt");

            boolean exists = file.exists();
            long length = file.length();

            Assert.assertTrue(exists);
            Assert.assertNotEquals(0, length);
        }catch (Exception e){}

    }

}
