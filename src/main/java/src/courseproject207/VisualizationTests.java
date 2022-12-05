package src.courseproject207;

import org.testng.annotations.Test;
import src.courseproject207.tree.Tree;

import java.util.ArrayList;
import java.util.HashSet;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class VisualizationTests {
    @Test
    public void testForestSize() {
        Forest forest = new Forest();
        assertEquals(forest.getTrees().size(), 4387);
        forest.addTree(new Tree(0,0,0,1,"Christmas", "Evergreen"));
        assertEquals(forest.getTrees().size(), 4388);
        for (int i = 0; i < 10; i++) {
            forest.addTree(new Tree(0,0,0,1,"Christmas", "Evergreen"));
        }
        assertEquals(forest.getTrees().size(), 4398);

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

        World3d world3d = new World3d(0,0);
        assertEquals(world3d.getForest().getTreeSpecies().get("SweetCherry").size(), 1);
    }
}
