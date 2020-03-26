import com.company.Counter;
import com.company.WordCounter;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClassTest {


    @Test
    public void existsAndNotEmpty() {

        Path path = Paths.get("src/test/java/testFileWith3Lines5Words9Characters.txt");
        String string = path.toAbsolutePath().toString();
        File file = new File(string);

        WordCounter counter = new Counter();
        int numberOfCharacters = counter.countCharacters(file);
        Assert.assertNotEquals(-1, numberOfCharacters);
        Assert.assertNotEquals(0, numberOfCharacters);

    }

    @Test
    public void fileDoesntExist() {

        Path path = Paths.get("src/test/java/wrong_file.txt");
        String string = path.toAbsolutePath().toString();
        File file = new File(string);

        WordCounter counter = new Counter();
        int numberOfCharacters = counter.countCharacters(file);
        Assert.assertEquals(numberOfCharacters, -1);

    }

    @Test
    public void checkTestFile() {

        Path path = Paths.get("src/test/java/testFileWith3Lines5Words9Characters.txt");
        String string = path.toAbsolutePath().toString();
        File file = new File(string);

        WordCounter counter = new Counter();
        int numberOfLines = counter.countLines(file);
        int numberOfWords = counter.countWords(file);
        int numberOfCharacters = counter.countCharacters(file);

        Assert.assertEquals(numberOfLines, 3);
        Assert.assertEquals(numberOfWords, 5);
        Assert.assertEquals(numberOfCharacters, 9);

    }

    @Test
    public void existingEmptyFile() {

        Path path = Paths.get("src/test/java/emptyFile.txt");
        String string = path.toAbsolutePath().toString();
        File file = new File(string);

        WordCounter counter = new Counter();
        int numberOfCharacters = counter.countCharacters(file);
        Assert.assertEquals(0, numberOfCharacters);

    }


}