package cyclicSort;

//This problem follows the Cyclic Sort pattern and shares similarities with Find the Missing Number.
// Following a similar approach, we will try to place each number on its correct index.
// Since there is only one duplicate, if while swapping the number with its index both the numbers being swapped are same, we have found our duplicate!
public class findDuplicate {

    class FindDuplicate {

        public  int findNumber(int[] nums) {
            int i = 0;
            while (i < nums.length) {
                if (nums[i] != i + 1) {
                    if (nums[i] != nums[nums[i] - 1])
                        swap(nums, i, nums[i] - 1);
                    else // we have found the duplicate
                        return nums[i];
                } else {
                    i++;
                }
            }

            return -1;
        }

        private  void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
