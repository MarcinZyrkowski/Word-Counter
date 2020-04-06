package com.company;

import java.io.File;
import java.io.PrintWriter;

public class KeepData {


    public File convert(String string) {

        File file = new File("tmpFile");

        try (PrintWriter writer = new PrintWriter("tmpFile")) {
            writer.println(string);
        } catch (Exception e) {
            e.getMessage();
        }

        return file;
    }

    public void removeFile() {
        try {
            File file = new File("tmpFile");
            file.delete();
        } catch (Exception e) {
        }

    }


}