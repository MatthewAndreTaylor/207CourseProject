package src.courseproject207.tree;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TreeFactory {
    Scanner reader;

    public void readFiles(String file) throws IOException
    {
        File f = new File(file);
        this.reader = new Scanner(f);
        while(reader.hasNext())
        {
            System.out.println(this.reader.nextLine());
        }
    }
}
