package subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class permutationOfSubset {
    class Permutations {

        public List<List<Integer>> findPermutations(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Queue<List<Integer>> permutations = new LinkedList<>();
            permutations.add(new ArrayList<>());
            for (int currentNumber : nums) {
                // we will take all existing permutations and add the current number to create new permutations
                int n = permutations.size();
                for (int i = 0; i < n; i++) {
                    List<Integer> oldPermutation = permutations.poll();
                    // create a new permutation by adding the current number at every position
                    for (int j = 0; j <= oldPermutation.size(); j++) {
                        List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
                        newPermutation.add(j, currentNumber);
                        if (newPermutation.size() == nums.length)
                            result.add(newPermutation);
                        else
                            permutations.add(newPermutation);
                    }
                }
            }
            return result;
        }
    }
}
