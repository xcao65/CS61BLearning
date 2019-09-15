package OA;

import java.util.Stack;

public class RemoveDuplicate {
    public String removeDuplicateLetters(String s) {
        //increasing Stack and count map;
        int[] map = new int[26];
        char[] arr = s.toCharArray();
        for (char ele : arr) {
            map[ele - 'a']++;
        }
        Stack<Character> incStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (map[arr[i] - 'a'] == 0) continue;

            while (!incStack.isEmpty() && incStack.peek() - arr[i] > 0) {
                incStack.pop();
            }
            incStack.push(arr[i]);
            map[arr[i] - 'a']--;

            if (map[arr[i] - 'a'] == 0) {
                StringBuilder tmp = new StringBuilder();
                while (!incStack.isEmpty()) {
                    tmp.insert(0, incStack.pop());
                }
                sb.append(tmp);
            }
        }
        return sb.toString();
    }
}
