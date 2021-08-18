package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//To handle this, we will do two extra things:
//
//Sort all numbers of the given set. This will ensure that all duplicate numbers are next to each other.
//Follow the same BFS approach but whenever we are about to process a duplicate (i.e., when the current and the previous numbers are same),
// instead of adding the current number (which is a duplicate)
// to all the existing subsets, only add it to the subsets which were created in the previous step.
public class subsetWitthDup {
    class SubsetWithDuplicates {

        public List<List<Integer>> findSubsets(int[] nums) {
            // sort the numbers to handle duplicates
            Arrays.sort(nums);
            List<List<Integer>> subsets = new ArrayList<>();
            subsets.add(new ArrayList<>());
            int startIndex = 0, endIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                startIndex = 0;
                // if current and the previous elements are same, create new subsets only from the subsets
                // added in the previous step
                if (i > 0 && nums[i] == nums[i - 1])
                    startIndex = endIndex + 1;
                endIndex = subsets.size() - 1;
                for (int j = startIndex; j <= endIndex; j++) {
                    // create a new subset from the existing subset and add the current element to it
                    List<Integer> set = new ArrayList<>(subsets.get(j));
                    set.add(nums[i]);
                    subsets.add(set);
                }
            }
            return subsets;
        }
    }
}
