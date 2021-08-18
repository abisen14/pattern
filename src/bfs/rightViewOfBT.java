package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightViewOfBT {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };

    class RightViewTree {
        public  List<TreeNode> traverse(TreeNode root) {
            List<TreeNode> result = new ArrayList<>();
            if (root == null)
                return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();
                    // if it is the last node of this level, add it to the result
                    if (i == levelSize - 1)
                        result.add(currentNode);
                    // insert the children of current node in the queue
                    if (currentNode.left != null)
                        queue.offer(currentNode.left);
                    if (currentNode.right != null)
                        queue.offer(currentNode.right);
                }
            }

            return result;
        }
    }
}
