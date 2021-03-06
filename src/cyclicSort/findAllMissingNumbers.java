package cyclicSort;

import java.util.ArrayList;
import java.util.List;

//Input: [2, 3, 1, 8, 2, 3, 5, 1]
//Output: 4, 6, 7

public class findAllMissingNumbers {
    static class AllMissingNumbers {

        public static List<Integer> findNumbers(int[] nums) {
            int i = 0;
            while (i < nums.length) {
                if (nums[i] != nums[nums[i] - 1])
                    swap(nums, i, nums[i] - 1);
                else
                    i++;
            }

            List<Integer> missingNumbers = new ArrayList<>();
            for (i = 0; i < nums.length; i++)
                if (nums[i] != i + 1)
                    missingNumbers.add(i + 1);

            return missingNumbers;
        }

        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
