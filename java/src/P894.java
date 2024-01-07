import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P894 {
    /**
     * https://leetcode.com/problems/all-possible-full-binary-trees/description/
     */
    public static void main(String[] args) {
        P894 p = new P894();
        System.out.println(p.allPossibleFBT(5));
    }

    /**
     *
     */
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> retval = new ArrayList<>();
        if(n % 2 == 0) return retval;
        if(n == 1) {
            retval.add(new TreeNode(0));
            return retval;
        } else if(n == 3) {
            TreeNode tree = new TreeNode(0, new TreeNode(), new TreeNode());
            retval.add(tree);
            return retval;
        } else {
            if(map.containsKey(n)) {
                return map.get(n);
            }
            for(int i = 2; i <= n - 1; i += 2) {
                List<TreeNode> leftPossible = allPossibleFBT(n - i);
                List<TreeNode> rightPossible = allPossibleFBT(i - 1);
                for(TreeNode lt : leftPossible) {
                    for(TreeNode rt : rightPossible) {
                        TreeNode tree = new TreeNode(0, lt, rt);
                        retval.add(tree);
                    }
                }
            }
            map.put(n, retval);
        }

        return retval;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        if(this.left == null && this.right == null) return "" + this.val;
        return this.val + ": " + "[" + this.left + "," + this.right + "]";
    }
}
