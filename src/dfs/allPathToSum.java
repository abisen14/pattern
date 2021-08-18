package dfs;

//Problem 1: Given a binary tree, return all root-to-leaf paths.
//
//Solution: We can follow a similar approach. We just need to remove the “check for the path sum.”
//
//Problem 2: Given a binary tree, find the root-to-leaf path with the maximum sum.

import java.util.ArrayList;
import java.util.List;

public class allPathToSum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };

    class FindAllTreePaths {
        public  List<List<Integer>> findPaths(TreeNode root, int sum) {
            List<List<Integer>> allPaths = new ArrayList<>();
            List<Integer> currentPath = new ArrayList<Integer>();
            findPathsRecursive(root, sum, currentPath, allPaths);
            return allPaths;
        }

        private  void findPathsRecursive(TreeNode currentNode, int sum, List<Integer> currentPath,
                                               List<List<Integer>> allPaths) {
            if (currentNode == null)
                return;

            // add the current node to the path
            currentPath.add(currentNode.val);

            // if the current node is a leaf and its value is equal to sum, save the current path
            if (currentNode.val == sum && currentNode.left == null && currentNode.right == null) {
                allPaths.add(new ArrayList<Integer>(currentPath));
            } else {
                // traverse the left sub-tree
                findPathsRecursive(currentNode.left, sum - currentNode.val, currentPath, allPaths);
                // traverse the right sub-tree
                findPathsRecursive(currentNode.right, sum - currentNode.val, currentPath, allPaths);
            }

            // remove the current node from the path to backtrack,
            // we need to remove the current node while we are going up the recursive call stack.
            currentPath.remove(currentPath.size() - 1);
        }
    }
}
