package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class reverseLevelOrderTraverse {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ;

    class ReverseLevelOrderTraversal {
        public List<List<Integer>> traverse(TreeNode root) {
            List<List<Integer>> result = new LinkedList<List<Integer>>();
            if (root == null)
                return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> currentLevel = new ArrayList<>(levelSize);
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();
                    // add the node to the current level
                    currentLevel.add(currentNode.val);
                    // insert the children of current node to the queue
                    if (currentNode.left != null)
                        queue.offer(currentNode.left);
                    if (currentNode.right != null)
                        queue.offer(currentNode.right);
                }
                // append the current level at the beginning
                result.add(0, currentLevel);
            }

            return result;
        }
    }
}
