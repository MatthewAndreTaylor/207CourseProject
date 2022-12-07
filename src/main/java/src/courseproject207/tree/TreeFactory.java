package src.courseproject207.tree;

import src.courseproject207.Forest;
import src.courseproject207.VisualizationApplication;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class TreeFactory {

    /**
     * Populate a forest with a reference to tree data
     * @param forest The forest to populate
     * @throws IOException resource not found
     */
    public void readFiles(Forest forest) throws IOException
    {
        File f = new File(Objects.requireNonNull(VisualizationApplication.class.getResource("Tree_Inventory.csv")).getFile());
        Scanner reader = new Scanner(f);
        String[] categoryNames = reader.nextLine().split(",");

        // Obtain all category names.
        while(reader.hasNext()) {

            // Read each line and parse the data for the tree.
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

                if (categoryHashMap.get(categoryNames[0]) != null && categoryHashMap.get("Y") != null
                        && categoryHashMap.get("OBJECTID") != null
                        && categoryHashMap.get("SPECIES_NAME") != null) {

                    String category = categoryHashMap.get("CATEGORY");
                    int id = Integer.parseInt(categoryHashMap.get("OBJECTID"));
                    int height = Integer.parseInt(categoryHashMap.get("HEIGHT_ESTM_LIDAR_2019_M"));
                    String speciesName = categoryHashMap.get("SPECIES_NAME");
                    double xCoordinate = Double.parseDouble(categoryHashMap.get(categoryNames[0]));
                    double yCoordinate = Double.parseDouble(categoryHashMap.get("Y"));
                    forest.addTree(this.createTree(id, xCoordinate, yCoordinate, height, speciesName, category));
                }
            }
        }
    }

    /**
     * Generate a given tree
     * @param id Tree id
     * @param x Tree x
     * @param y Tree y
     * @param height Tree height
     * @param speciesName Tree species name
     * @param category Tree family
     * @return a Concrete tree from the params
     */
    private Tree createTree(int id, double x, double y, int height, String speciesName,String category) {
        return new Tree(id, x,y,height,speciesName,category);
    }
}
