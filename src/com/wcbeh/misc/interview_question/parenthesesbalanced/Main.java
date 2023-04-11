package com.wcbeh.misc.interview_question.parenthesesbalanced;

public class Main {

    /**
     * Time Complexity :: O(n)
     * Space Complexity :: O(1)
     * @param str
     * @return
     */
    private static boolean isBalancedParentheses(String str) {
        if (str == null) return false;
        int i = -1;
        char[] stack = new char[str.length()];
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack[++i] = ch;
            } else {
                // prevent i goes lower than 0 to cater case '())('
                if (i >= 0 && stack[i] == '(' && ch == ')') {
                    i--;
                } else {
                    return false;
                }
            }
        }

        return i == -1;
    }

    /**
     * Time Complexity :: O(n)
     * Space Complexity :: O(n)
     * @param str
     * @return
     */
    private static boolean isBalancedParentheses(String str, boolean myOwnAnswer) {
        if (str == null) return false;
        Stack<Character> stack = new Stack<>();
        for (Character c : str.toCharArray()) {
            if (c == ')' ) {
                if (stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s1 = "()()()";
        String s2 = "()(()";
        String s3 = "(()())";
        String s4 = "())(";
        System.out.println(isBalancedParentheses(s1)); // true
        System.out.println(isBalancedParentheses(s2)); // false
        System.out.println(isBalancedParentheses(s3)); // true
        System.out.println(isBalancedParentheses(s4)); // false

        /*
            EXPECTED OUTPUT:
            ----------------
            true
            false
            true
            false
        */
    }
}

