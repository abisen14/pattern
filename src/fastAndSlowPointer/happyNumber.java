package fastAndSlowPointer;

public class happyNumber {

    //The process, defined above, to find out if a number is a happy number or not, always ends in a cycle.
    // If the number is a happy number, the process will be stuck in a cycle on number ‘1,’ and if the number is not a happy
    // number then the process will be stuck in a cycle with a set of numbers. As we saw in Example-2 while determining if ‘12’ is a happy number or not,
    // our process will get stuck in a cycle with the following numbers: 89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89

    class HappyNumber {

        public  boolean find(int num) {
            int slow = num, fast = num;
            do {
                slow = findSquareSum(slow); // move one step
                fast = findSquareSum(findSquareSum(fast)); // move two steps
            } while (slow != fast); // found the cycle

            return slow == 1; // see if the cycle is stuck on the number '1'
        }

        private  int findSquareSum(int num) {
            int sum = 0, digit;
            while (num > 0) {
                digit = num % 10;
                sum += digit * digit;
                num /= 10;
            }
            return sum;
        }

        public void main(String[] args) {
            System.out.println(HappyNumber.find(23));
            System.out.println(HappyNumber.find(12));
        }
    }
}
