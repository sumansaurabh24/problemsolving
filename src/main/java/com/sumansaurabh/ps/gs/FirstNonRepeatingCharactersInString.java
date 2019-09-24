package com.sumansaurabh.ps.gs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class FirstNonRepeatingCharactersInString {

    static char findFirst(String s) {
        if (s == null || s.trim().length() == 0) {
            return '@';
        }

        Map<Character, Integer> characterCountMap = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Integer count = characterCountMap.get(s.charAt(i));
            if (count == null) {
                characterCountMap.put(s.charAt(i), 1);
            } else {
                count = count + 1;
                characterCountMap.put(s.charAt(i), count);
            }
        }

        Optional<Character> optionalCharacter = characterCountMap.entrySet()
                .stream()
                .filter(e -> (e.getValue() == 1))
                .map(Map.Entry::getKey)
                .findFirst();
        if (optionalCharacter.isPresent()) {
            return optionalCharacter.get();
        }

        return '@';
    }

    public static void main(String[] args) {
        Map<String, Character> testCases = new HashMap<>();
        testCases.put("apple", 'a');
        testCases.put("", '@');
        testCases.put(" ", '@');
        testCases.put("v", 'v');
        testCases.put("racecars", 'e');
        testCases.put("ababdc", 'd');

        testCases.forEach((k, v) -> {
            char foundChar = findFirst(k);
            if (foundChar == v) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
        });
    }
}
