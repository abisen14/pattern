package dfs;

//The time complexity of the above algorithm is O(N)O(N), where ‘N’ is the total number of nodes in the tree.
// This is due to the fact that we traverse each node once.
public class diameterfTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };

    class TreeDiameter {

        private int treeDiameter = 0;

        public int findDiameter(TreeNode root) {
            calculateHeight(root);
            return treeDiameter;
        }

        private int calculateHeight(TreeNode currentNode) {
            if (currentNode == null)
                return 0;

            int leftTreeHeight = calculateHeight(currentNode.left);
            int rightTreeHeight = calculateHeight(currentNode.right);

            // if the current node doesn't have a left or right subtree, we can't have
            // a path passing through it, since we need a leaf node on each side
            if (leftTreeHeight != 0 && rightTreeHeight != 0) {

                // diameter at the current node will be equal to the height of left subtree +
                // the height of right sub-trees + '1' for the current node
                int diameter = leftTreeHeight + rightTreeHeight + 1;

                // update the global tree diameter
                treeDiameter = Math.max(treeDiameter, diameter);
            }

            // height of the current node will be equal to the maximum of the heights of
            // left or right subtrees plus '1' for the current node
            return Math.max(leftTreeHeight, rightTreeHeight) + 1;
        }
    }
}
