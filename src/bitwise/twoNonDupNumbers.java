package bitwise;
//We can take any bit which is ‘1’ in n1xn2 and partition all numbers in the given array into two groups based on that bit.
// One group will have all those numbers with that bit set to ‘0’ and the other with the bit set to ‘1’.
// This will ensure that num1 will be in one group and num2 will be in the other. We can take XOR of all numbers in each group separately to get num1 and num2,
// as all other numbers in each group will cancel each other. Here are the steps of our algorithm:
//
//Taking XOR of all numbers in the given array will give us XOR of num1 and num2, calling this XOR as n1xn2.
//Find any bit which is set in n1xn2. We can take the rightmost bit which is ‘1’. Let’s call this rightmostSetBit.
//Iterate through all numbers of the input array to partition them into two groups based on rightmostSetBit.
// Take XOR of all numbers in both the groups separately. Both these XORs are our required numbers.

//Input: [1, 4, 2, 1, 3, 5, 6, 2, 3, 5]
//Output: [4, 6]
public class twoNonDupNumbers {
    public static int[] findSingleNumbers(int[] nums) {
        // get the XOR of the all the numbers
        int n1xn2 = 0;
        for (int num : nums) {
            n1xn2 ^= num;
        }

        // get the rightmost bit that is '1'
        int rightmostSetBit = 1;
        while ((rightmostSetBit & n1xn2) == 0) {
            rightmostSetBit = rightmostSetBit << 1;
        }
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) // the bit is set
                num1 ^= num;
            else // the bit is not set
                num2 ^= num;
        }
        return new int[] { num1, num2 };
    }
}
