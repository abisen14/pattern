package dfs;

public class sumOfPathNumbers {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ;

    class SumOfPathNumbers {
        public int findSumOfPathNumbers(TreeNode root) {
            return findRootToLeafPathNumbers(root, 0);
        }

        private int findRootToLeafPathNumbers(TreeNode currentNode, int pathSum) {
            if (currentNode == null)
                return 0;

            // calculate the path number of the current node
            pathSum = 10 * pathSum + currentNode.val;

            // if the current node is a leaf, return the current path sum.
            if (currentNode.left == null && currentNode.right == null) {
                return pathSum;
            }

            // traverse the left and the right sub-tree
            return findRootToLeafPathNumbers(currentNode.left, pathSum) +
                    findRootToLeafPathNumbers(currentNode.right, pathSum);
        }
    }
}
