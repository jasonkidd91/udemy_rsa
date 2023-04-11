package com.wcbeh.misc.interview_question.stackreversestring;

public class Main {

    /**
     * Time Complexity :: O(n)
     * Space Complexity :: O(1)
     * @param str
     * @return
     */
    public static String reverseString(String str, String anotherAnswer) {
        if (str == null) return null;
        StringBuilder res = new StringBuilder(str);
        int mid = str.length() / 2;
        int i = 0;
        int j = str.length() - 1;
        while (true) {
            if (i > mid || j < mid) break;
            char temp = str.charAt(i);
            res.setCharAt(i, str.charAt(j));
            res.setCharAt(j, temp);
            i ++; j --;
        }
        return res.toString();
    }

    /**
     * Time Complexity :: O(n)
     * Space Complexity :: O(1)
     * @param str
     * @return
     */
    public static String reverseString(String str) {
        if (str == null) return null;
        StringBuilder res = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            res.append(str.charAt(i));
        }
        return res.toString();
    }

    /**
     * Time Complexity :: O(n)
     * Space Complexity :: O(n)
     * @param str
     * @return
     */
    public static String reverseString(String str, boolean myOwnAnswer) {
        if (str == null) return null;
        Stack<String> stack = new Stack<>();
        for (String s : str.split("")) {
            stack.push(s);
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.toString();
    }



    public static void main(String[] args) {

        String myString = "hello";
        String reversedString = reverseString(myString);
        System.out.println(reversedString);

        /*
            EXPECTED OUTPUT:
            ----------------
            olleh
        */

    }

}

