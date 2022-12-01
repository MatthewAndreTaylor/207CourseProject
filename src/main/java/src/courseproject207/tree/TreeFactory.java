package src.courseproject207.tree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TreeFactory {
    Scanner reader;

    public void readFiles(String file, ArrayList<Tree> trees) throws IOException
    {

        File f = new File(file);
        this.reader = new Scanner(f);
        String[] categoryNames = this.reader.nextLine().split(",");

        // Obtain all category names.

        while(reader.hasNext()) {

            // read each line and parse the data for the tree.

            String newLine = reader.nextLine();

            String[] newLineCategories = newLine.split(",");

            if (newLineCategories.length == 46) {

                HashMap<String, String> categoryHashMap = new HashMap<>();

                for (int index = 0; index <= categoryNames.length - 1; index++) {

                    categoryHashMap.put(categoryNames[index], newLineCategories[index]);

                }

                //X, Y, OBJECTID,
                // Default length: 60
                // Default width: 40
                // Default Height: 190

                if (categoryHashMap.get(categoryNames[0]) != null && categoryHashMap.get("Y") != null
                        && categoryHashMap.get("OBJECTID") != null
                        && categoryHashMap.get("SPECIES_NAME") != null) {

                    int id = Integer.parseInt(categoryHashMap.get("OBJECTID"));
                    int defaultHeight = 40;
                    String speciesName = categoryHashMap.get("SPECIES_NAME");
                    double xCoordinate = Double.parseDouble(categoryHashMap.get(categoryNames[0]));
                    double yCoordinate = Double.parseDouble(categoryHashMap.get("Y"));
                    trees.add(this.createTree(id, xCoordinate, yCoordinate, defaultHeight, speciesName));

                }

            }

        }

    }

    private Tree createTree(int id, double x, double y, int height, String speciesName) {

        return new CommonTree(id, x, y, height, speciesName);

    }

}
