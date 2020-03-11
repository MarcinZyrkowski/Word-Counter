import com.company.WordCounter;
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

    @Test
    public void FileDoesntExist(){

        try {
            File file = new File("x.txt");
            boolean exists = file.exists();
            Assert.assertFalse(exists);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void WrongFlagAndGoodFile(){

        try{
            WordCounter wordCounter = new WordCounter("test.txt","incorrect flag");
            int wrongFlag = wordCounter.Count();
            Assert.assertEquals(wrongFlag,-1);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void WrongFileAndGoodFlag(){

        try{
            WordCounter wordCounter = new WordCounter("x.txt","w");
            int wrongFile = wordCounter.Count();
            Assert.assertEquals(wrongFile,-1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void CheckTestFile(){

        try{
            WordCounter wordCounterLine = new WordCounter("test.txt","l");
            int numberOfLines = wordCounterLine.Count();
            WordCounter wordCounterWords = new WordCounter("test.txt","w");
            int numberOfWords = wordCounterWords.Count();
            WordCounter wordCounterCharacters = new WordCounter("test.txt","c");
            int numberOfCharacters = wordCounterCharacters.Count();

            Assert.assertEquals(numberOfLines,3);
            Assert.assertEquals(numberOfWords,5);
            Assert.assertEquals(numberOfCharacters,9);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }




}
