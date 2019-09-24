package com.sumansaurabh.ps.gs;

import java.util.HashMap;
import java.util.Map;

public class ReverseString {

    static String reverse(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int length = chars.length;

        for (int i = 0; i < length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[length - i -1];
            chars[length - i -1] = temp;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Map<String, String> testCases = new HashMap<>();
        testCases.put("abcd", "dcba");
        testCases.put(" ", "");
        testCases.put("", "");
        testCases.put(null, "");
        testCases.put("apple", "elppa");

        testCases.forEach((k, v) -> {
            String reversed = reverse(k);
            if (reversed.equals(v)) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
        });
    }
}
