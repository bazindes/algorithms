package google;

import com.baz.app.google.DiameterOfBinaryTree;
import com.baz.app.util.TreeNode;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DiameterOfBinaryTreeTest {

    @Test
    public void test(){
        TreeNode r = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode l2 = new TreeNode(4);
        TreeNode r2 = new TreeNode(5);
        r.left = l1;
        r.right = r1;
        l1.left = l2;
        l1.right = r2;
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        int re = diameterOfBinaryTree.dp(r);

        assertEquals(3, re);
    }

}
