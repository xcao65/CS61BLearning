package OA;

public class LongestValidSubstring {
    public int getLongest(String input) {
        //Two Pointer i , j: i marks head, j marks tail.
        //j moves forward, if j meets invalid, i jumps to j+1
        //if j meets "A" capCt++

        /*
         * A String is valid if contains at least one capital letter
         * and contains no digits
         *
         * given a non-empty string, return the length of longest valid
         * substring. If no valid string exists, return -1.
         *
         * all the characters are alphanumerical (a-z, A-Z, 0-9)
         *
         * E.g.
         * input: "a0Ba"
         * return: 2
         *
         * */
        int capCt = 0;
        int maxLen = -1;
        int i = 0;
        int j = 0;
        while (j < input.length()) {
            char cur = input.charAt(j);
            if (Character.isDigit(cur)) {
                i = j + 1;
                capCt = 0;
            } else if (Character.isLowerCase(cur)) {
                if (capCt > 0) maxLen = Math.max(maxLen, j - i + 1);
            } else {
                capCt++;
                maxLen = Math.max(maxLen, j - i + 1);
            }
            j++;
        }
        return maxLen;
    }
}
