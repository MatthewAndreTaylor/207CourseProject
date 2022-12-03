package src.courseproject207;

import src.courseproject207.tree.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.*;

public class Forest {
    private ArrayList<Tree> trees;
    private HashMap<String, ArrayList<Tree>> treeSpecies;
    private HashMap<String, HashSet<String>> treeFamilies;
    private TreeFactory treeFactory;

    public Forest()
    {
        this.treeFactory = new TreeFactory();
        this.trees = new ArrayList<>();
        this.treeSpecies = new HashMap<>();
        this.treeFamilies = new HashMap<>();
        this.generateTrees();
    }

    /**
     * Generate and populate tree's for this given forest
     */
    private void generateTrees()
    {
        try
        {
            this.treeFactory.readFiles(this);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Add Tree t to the forest
     * @param t Tree to be added
     */
    public void addTree(Tree t)
    {
        String type = t.getSpeciesName();
        String family = t.getFamily();

        // Add the tree to the list of trees for this species
        if(!this.treeSpecies.containsKey(type)) {
            this.treeSpecies.put(type, new ArrayList<>(List.of(t)));
        }
        else {
            this.treeSpecies.get(type).add(t);
        }

        // Add the species to the list of species for this family of trees
        if(!this.treeFamilies.containsKey(family)) {
            this.treeFamilies.put(family, new HashSet<>(Set.of(type)));
        }
        else {
            this.treeFamilies.get(family).add(type);
        }

        this.trees.add(t);
    }

    /**
     * Remove Tree t from the forest
     * @param t Tree to be removed
     */
    public void removeTree(Tree t)
    {
        this.treeSpecies.get(t.getSpeciesName()).remove(t);

        this.trees.remove(t);
    }

    /**
     * @return ArrayList of trees in this forest
     */
    public ArrayList<Tree> getTrees()
    {
        return this.trees;
    }

    /**
     * @return A mapping of species names to trees of that species
     */
    public HashMap<String, ArrayList<Tree>> getTreeSpecies() {
        return this.treeSpecies;
    }
    /**
     * @return A mapping of family names to a set species names of that family
     */
    public HashMap<String, HashSet<String>> getTreeFamilies() {
        return treeFamilies;
    }
}
