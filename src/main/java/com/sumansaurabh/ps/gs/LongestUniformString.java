package com.sumansaurabh.ps.gs;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class LongestUniformString {

    static int[] find(String s) {
        int firstIndex = 0;
        int length = 0;

        if (s == null || s.trim().length() == 0) {
            return new int[]{firstIndex, length};
        }

        char character = s.charAt(0);
        int currentLength = 1;
        int currentIndex = 0;
        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) != character) {
                character = s.charAt(i);
                currentIndex = i;
                currentLength = 1;
            } else {
                currentLength++;
            }

            if(currentLength > length){
                length = currentLength;
                firstIndex = currentIndex;
            }

        }

        return new int[]{firstIndex, length};
    }

    public static void main(String[] args) {

        Map<String , int[]> testCases = new LinkedHashMap<>();

        testCases.put("abbbccda", new int[]{1, 3});
        testCases.put("aabbbbbCdAAAAAAA", new int[]{9,7});
        testCases.put("10000111", new int[]{1,4});
        testCases.put(" ", new int[]{0, 0});

        testCases.forEach((k , v) -> {
            int[] result = find(k);
            boolean passed = Arrays.equals(result, v);
            if(passed){
                System.out.println("TestCases PASSED for string : " + k);
            }else{
                System.out.println("Testcase FAILED for string : " + k);
            }
        });

    }
}
