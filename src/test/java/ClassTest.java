import com.company.Counter;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class ClassTest {


    @Test
    public void existsAndNotEmpty() {
        Counter counter = new Counter();
        int numberOfCharacters = counter.countCharacters(new File("/Users/mzyrkowski/IdeaProjects/Ważne - zadania/007_Word_Counter_New/src/test/java/testFileWith3Lines5Words9Characters.txt"));
        Assert.assertNotEquals(-1, numberOfCharacters);
        Assert.assertNotEquals(0,numberOfCharacters);

    }

    @Test
    public void fileDoesntExist() {

            Counter counter = new Counter();
            int numberOfCharacters = counter.countCharacters(new File("/Users/wrong_paths.txt"));
            Assert.assertEquals(numberOfCharacters,-1);

    }

    @Test
    public void checkTestFile() {

            Counter counter = new Counter();
            int numberOfLines = counter.countLines(new File("/Users/mzyrkowski/IdeaProjects/Ważne - zadania/007_Word_Counter_New/src/test/java/testFileWith3Lines5Words9Characters.txt"));
            int numberOfWords = counter.countWords(new File("/Users/mzyrkowski/IdeaProjects/Ważne - zadania/007_Word_Counter_New/src/test/java/testFileWith3Lines5Words9Characters.txt"));
            int numberOfCharacters = counter.countCharacters(new File("/Users/mzyrkowski/IdeaProjects/Ważne - zadania/007_Word_Counter_New/src/test/java/testFileWith3Lines5Words9Characters.txt"));

            Assert.assertEquals(numberOfLines, 3);
            Assert.assertEquals(numberOfWords, 5);
            Assert.assertEquals(numberOfCharacters, 9);

    }

    @Test
    public void existingEmptyFile(){
        Counter counter = new Counter();
        int numberOfCharacters = counter.countCharacters(new File("/Users/mzyrkowski/IdeaProjects/Ważne - zadania/007_Word_Counter_New/src/test/java/emptyFile.txt"));
        Assert.assertEquals(0,numberOfCharacters);
        Assert.assertNotEquals(-1,numberOfCharacters);

    }


}
