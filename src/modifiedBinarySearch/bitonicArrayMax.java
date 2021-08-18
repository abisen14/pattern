package modifiedBinarySearch;

//Input: [1, 3, 8, 12, 4, 2]
//Output: 12
//Explanation: The maximum number in the input bitonic array is '12'.

//If arr[middle] > arr[middle + 1], we are in the second (descending) part of the bitonic array.
// Therefore, our required number could either be pointed out by middle or will be before middle. This means we will be doing: end = middle.
//If arr[middle] < arr[middle + 1], we are in the first (ascending) part of the bitonic array.
//Therefore, the required number will be after middle. This means we will be doing: start = middle + 1.
//We can break when start == end. Due to the two points mentioned above, both start and end will be pointing at the maximum number of the bitonic array.
public class bitonicArrayMax {
    public static int findMax(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        // at the end of the while loop, 'start == end'
        return arr[start];
    }
}
