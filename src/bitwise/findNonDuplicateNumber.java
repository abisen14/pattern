package bitwise;

public class findNonDuplicateNumber {
    public static int findSingleNumber(int[] arr) {
        int num = 0;
        for (int i=0; i < arr.length; i++) {
            num = num ^ arr[i];
        }
        return num;
    }
}
