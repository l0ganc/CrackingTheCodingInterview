package TreesAndGraphs;

import CtCILibrary.TreeNode;

public class ValidateBST_4_5 {

    /**
     * time complexity O(n) since we have to touch n nodes
     * space complexity O(log(n)) since up tp 0(logn) recursive calls
     * @param n
     * @return
     */
    boolean checkBST(TreeNode n) {
        return checkBST(n, null, null);
    }

    boolean checkBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if ((min != null && root.data <= min) || (max != null && root.data > max)) {
            return false;
        }

        if (!checkBST(root.left, min, root.data) || !checkBST(root.right, root.data, max)) {
            return false;
        }
        return true;
    }
}
