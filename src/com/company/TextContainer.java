package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@SaveTo(myPath = "F:\\file.txt")
public class TextContainer {
    public String text = "your gay";


    @Saver
    public void save(String myPath, String text) throws IOException {
       FileWriter writer= new FileWriter(myPath, false);
       writer.write(text);
       System.out.println(text);
       System.out.println(myPath);
        writer.flush();
    }
}

