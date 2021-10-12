package fbTop;

public class alienDict {
    //Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
    //Output: true
    //Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {

            for (int j = 0; j < words[i].length(); j++) {
                // If we do not find a mismatch letter between words[i] and words[i + 1],
                // we need to examine the case when words are like ("apple", "app").
                if (j >= words[i + 1].length()) return false;

                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    char currentWordChar = words[i].charAt(j) ;
                    char nextWordChar = words[i + 1].charAt(j) ;
                    System.out.println("Index of ; " + currentWordChar + " is:: " + order.indexOf(currentWordChar));
                    if (order.indexOf(currentWordChar) > order.indexOf(nextWordChar) )return false;
                        // if we find the first different letter and they are sorted,
                        // then there's no need to check remaining letters
                    else break;
                }
            }
        }

        return true;
    }
}
