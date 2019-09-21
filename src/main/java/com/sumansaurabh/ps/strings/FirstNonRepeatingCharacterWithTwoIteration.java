package com.sumansaurabh.ps.strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterWithTwoIteration {

    static Character findFirstNonRepeating(String s) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        //find count of each character and store in chars array
        for (int i = 0; i < s.length(); i++) {

            Integer count = charCountMap.get(s.charAt(i));
            if (count == null) {
                charCountMap.put(s.charAt(i), 1);
            } else {
                charCountMap.put(s.charAt(i), count + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null;
    }


    public static void main(String[] args) {
        String s = "geeksforgeeks";
        char found = findFirstNonRepeating(s);
        System.out.println("First non repeating character is : " + found);
    }
}
