package OA;

import java.util.Stack;

public class Calculator {
    public int calculate(String s) {
        //Use Stack to hold ( ...
        //when reach ) pop stack to calculate (....)
        //push back into stack and continue push into stack
        //after all ends of stack, calculate left elements in stack, no () anymore, plan calculation
        //Assumption: valid express always
        //Note: deal with negative value
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char cur = s.charAt(i);
            if (cur == ' ') {
                i++;
                continue;
            }
            if (cur == ')') {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '(') {
                    sb.insert(0, stack.pop());
                }
                stack.pop();
                int tmpRes = plainCal(sb.toString());
                String tmpStr = "";
                if (tmpRes < 0) {
                    tmpRes = -tmpRes;
                    tmpStr = "-" + tmpRes;
                } else {
                    tmpStr = "+" + tmpRes;
                }
                for (int j = 0; j < tmpStr.length(); j++) {
                    stack.push(tmpStr.charAt(j));
                }
                i++;
            } else if (Character.isDigit(cur)) {
                //Add sign before each number
                stack.push('+');
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    stack.push(s.charAt(i));
                    i++;
                }
            } else {
                stack.push(cur);
                i++;
            }
        }

        StringBuilder sb2 = new StringBuilder();
        while (!stack.isEmpty()) {
            sb2.insert(0, stack.pop());
        }
        return plainCal(sb2.toString());
    }

    private int plainCal(String s) {
        //input has no space
        if (!s.contains("++") && !s.contains("-+") && !s.contains("+-") && !s.contains("--")) {
            int val = Integer.valueOf(s.substring(1, s.length()));
            if (s.charAt(0) == '-') return -val;
            return val;
        }
        int res = 0;
        int start = 0;
        int e1 = 0;
        int e2 = e1 + 1;
        boolean add = true;
        while (e2 < s.length()) {
            char cur1 = s.charAt(e1);
            char cur2 = s.charAt(e2);
            if ((cur1 != '+' && cur1 != '-') || (cur2 != '+' && cur2 != '-')) {
                e1++;
                e2++;
                continue;
            } else {
                if (s.charAt(start) == '-') add = !add;
                int tmpVal = Integer.valueOf(s.substring(start + 1, e1));
                if (add) {
                    res += tmpVal;
                } else {
                    res -= tmpVal;
                }
                start = e2;
                if (cur1 == '+') {
                    add = true;
                } else {
                    add = false;
                }
                e1++;
                e2++;
            }
        }
        if (s.charAt(start) == '-') add = !add;
        int resVal = Integer.valueOf(s.substring(start + 1, e2));
        if (add) {
            res += resVal;
        } else {
            res -= resVal;
        }
        return res;
    }
}
