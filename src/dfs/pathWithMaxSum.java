package dfs;

public class pathWithMaxSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };

    class MaximumPathSum {

        private int globalMaximumSum;

        public int findMaximumPathSum(TreeNode root) {
            globalMaximumSum = Integer.MIN_VALUE;
            findMaximumPathSumRecursive(root);
            return globalMaximumSum;
        }

        private int findMaximumPathSumRecursive(TreeNode currentNode) {
            if (currentNode == null)
                return 0;

            int maxPathSumFromLeft = findMaximumPathSumRecursive(currentNode.left);
            int maxPathSumFromRight = findMaximumPathSumRecursive(currentNode.right);

            // ignore paths with negative sums, since we need to find the maximum sum we should
            // ignore any path which has an overall negative sum.
            maxPathSumFromLeft = Math.max(maxPathSumFromLeft, 0);
            maxPathSumFromRight = Math.max(maxPathSumFromRight, 0);

            // maximum path sum at the current node will be equal to the sum from the left subtree +
            // the sum from right subtree + val of current node
            int localMaximumSum = maxPathSumFromLeft + maxPathSumFromRight + currentNode.val;

            // update the global maximum sum
            globalMaximumSum = Math.max(globalMaximumSum, localMaximumSum);

            // maximum sum of any path from the current node will be equal to the maximum of
            // the sums from left or right subtrees plus the value of the current node
            return Math.max(maxPathSumFromLeft, maxPathSumFromRight) + currentNode.val;
        }
    }
}
