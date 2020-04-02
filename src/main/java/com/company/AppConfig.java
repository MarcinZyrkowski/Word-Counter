package com.company;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;


@Configuration
public class AppConfig {


    @Bean(name = "pathFile")
    public File pathFile() {
        return new File("/Users/mzyrkowski/IdeaProjects/Ważne - zadania/007_Word_Counter_New/src/test/java/testFileWith3Lines5Words9Characters.txt");
    }

    @Bean(name = "counter")
    public WordCounter counter(File file) {
        return new Counter(file);
    }


}
