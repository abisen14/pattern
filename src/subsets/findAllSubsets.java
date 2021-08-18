package subsets;

import java.util.ArrayList;
import java.util.List;

//Given set: [1, 5, 3]
//
//Start with an empty set: [[]]
//Add the first number (1) to all the existing subsets to create new subsets: [[], [1]];
//Add the second number (5) to all the existing subsets: [[], [1], [5], [1,5]];
//Add the third number (3) to all the existing subsets: [[], [1], [5], [1,5], [3], [1,3], [5,3], [1,5,3]].

//Time complexity #
//Since, in each step, the number of subsets doubles as we add each element to all the existing subsets, therefore, we will have a total of O(2^N)O(2
//​N
//​​ ) subsets, where ‘N’ is the total number of elements in the input set. And since we construct a new subset from an existing set, therefore, the time complexity of the above algorithm will be O(N*2^N)O(N∗2
//​N
//​​ ).
//
//Space complexity #
//All the additional space used by our algorithm is for the output list. Since we will have a total of O(2^N)O(2
//​N
//​​ ) subsets, and each subset can take up to O(N)O(N) space, therefore, the space complexity of our algorithm will be O(N*2^N)O(N∗2
//​N
//​​ ).
public class findAllSubsets {

    class Subsets {

        public  List<List<Integer>> findSubsets(int[] nums) {
            List<List<Integer>> subsets = new ArrayList<>();
            // start by adding the empty subset
            subsets.add(new ArrayList<>());
            for (int currentNumber : nums) {
                // we will take all existing subsets and insert the current number in them to create new subsets
                int n = subsets.size();
                for (int i = 0; i < n; i++) {
                    // create a new subset from the existing subset and insert the current element to it
                    List<Integer> set = new ArrayList<>(subsets.get(i));
                    set.add(currentNumber);
                    subsets.add(set);
                }
            }
            return subsets;
        }
    }

    }
