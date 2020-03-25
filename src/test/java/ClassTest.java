import com.company.Counter;
import com.company.WordCounter;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ClassTest {


    @Test
    public void lookingForPath() {
        Path path = Paths.get("src/test/java/x.txt");
        String string = path.toAbsolutePath().toString();
        File file = new File(string);

        try {
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                System.out.println(read.nextLine());
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

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

    @Test
    public void testCharactersMethod() {
        String string = "12345 12345 12345";
        Scanner scanner = new Scanner(string);
        int characters = 0;
        while (scanner.hasNext()) {
            String a = scanner.next();
            characters += a.length();
        }
        Assert.assertEquals(characters, string.replaceAll("\\s", "").toCharArray().length);
    }

    @Test
    public void testWordsMethod() {
        String string = "12345 12345 12345";
        Scanner scanner = new Scanner(string);
        int words = 0;
        while (scanner.hasNext()) {
            scanner.next();
            words++;
        }

        Assert.assertEquals(words, string.split("\\s").length);
    }


}