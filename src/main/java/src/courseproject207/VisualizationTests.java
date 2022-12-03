package src.courseproject207;

import org.testng.annotations.Test;
import src.courseproject207.tree.Tree;

import java.util.ArrayList;
import java.util.HashSet;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class VisualizationTests {
    @Test
    public void testForestSize() {
        Forest forest = new Forest();
        assertEquals(forest.getTrees().size(), 4387, "Error when testing Forest");
        forest.addTree(new Tree(0,0,0,1,"Christmas", "EverGreen"));
        assertEquals(forest.getTrees().size(), 4388, "Error when testing adding a single Tree");
        for (int i = 0; i < 10; i++) {
            forest.addTree(new Tree(0,0,0,1,"Christmas", "EverGreen"));
        }
        assertEquals(forest.getTrees().size(), 4398, "Error when testing single Tree");

        int speciesCount = 0;
        for(String species: forest.getTreeSpecies().keySet())
        {
            speciesCount += forest.getTreeSpecies().get(species).size();
        }

        assertEquals(forest.getTrees().size(), speciesCount);
    }

    @Test
    public void testUniqueForest()
    {
        Forest forest = new Forest();
        boolean allUnique = true;
        HashSet<Integer> ids = new HashSet<>();
        for(Tree t: forest.getTrees())
        {
            if(ids.contains(t.getId()))
            {
                allUnique = false;
                break;
            }
            ids.add(t.getId());
        }
        assertTrue(allUnique);
    }

    @Test
    public void testForestSpecies()
    {
        Forest forest = new Forest();
        assertEquals(forest.getTreeSpecies().keySet().size(), 115);
        ArrayList<Tree> treeArrayList = new ArrayList<>(forest.getTrees());
        for(Tree t: treeArrayList)
        {
            forest.removeTree(t);
        }
        assertEquals(forest.getTreeSpecies().get("Maple").size(), 0);
    }
}
