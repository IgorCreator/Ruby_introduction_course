package easy;

import org.junit.Before;
import org.junit.Test;

import easy.MergeTwoBinaryTrees.TreeNode;

import static org.junit.Assert.*;

public class MergeTwoBinaryTreesTest {

    TreeNode t1;
    TreeNode t2;
    TreeNode rez;

    @Before
    public void init(){
        TreeNode oneA = new TreeNode(1);
        TreeNode twoA = new TreeNode(2);
        TreeNode threeA = new TreeNode(3);
        TreeNode fiveA = new TreeNode(5);

        t1 = oneA;
        t1.left = threeA;
        t1.right = twoA;
        threeA.left = fiveA;

        TreeNode oneB = new TreeNode(1);
        TreeNode twoB = new TreeNode(2);
        TreeNode threeB = new TreeNode(3);
        TreeNode fourB = new TreeNode(4);
        TreeNode sevenB = new TreeNode(7);

        t2 = twoB;
        t2.left = oneB;
        t2.right = threeB;
        oneB.right = fourB;
        threeB.right = sevenB;

        TreeNode threeRez = new TreeNode(3);
        TreeNode fourARez = new TreeNode(4);
        TreeNode fiveARez = new TreeNode(5);
        TreeNode fourBRez = new TreeNode(4);
        TreeNode fiveBRez = new TreeNode(5);
        TreeNode sevenRez = new TreeNode(7);

        rez = threeRez;
        rez.left = fourARez;
        rez.right = fiveARez;
        fourARez.left = fiveBRez;
        fourARez.right = fourBRez;
        fiveARez.right = sevenRez;

    }

    @Test
    public void mergeTreesTest() {
        MergeTwoBinaryTrees aCase = new MergeTwoBinaryTrees();
        assertEquals(rez, aCase.mergeTrees(t1, t2));
        assertEquals(rez, aCase.mergeTreesNotMineDecision(t1, t2));
        assertEquals(new TreeNode(0), aCase.mergeTrees(new TreeNode(0), null));
        assertEquals(new TreeNode(0), aCase.mergeTreesNotMineDecision(new TreeNode(0), null));
    }



}