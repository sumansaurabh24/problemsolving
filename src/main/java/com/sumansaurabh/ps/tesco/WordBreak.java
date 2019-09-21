package com.sumansaurabh.ps.tesco;

import java.util.*;

public class WordBreak {

    private final HashSet vocabulary = new HashSet<>(
            Arrays.asList("every", "ever", "very", "only", "on",
                    "one", "everyone", "love", "loves", "i", "sapient"));

    public String getSentences(final String input) {
        final String text = input.toLowerCase();
        final List<String> result = new ArrayList<>();

        int right = text.length();
        while (right != 0) {
            for (int index = 0; index <= right; index++) {
                String word = text.substring(index, right);

                //System.out.println(word);

                if (vocabulary.contains(word)) {
                    right = index;
                    result.add(word);
                }
            }

            if (result.isEmpty()) right = 0;
        }

        Collections.reverse(result);
        return String.join(" ", result);
    }

    public static void main(String[] args) {
        final String[] inputs = {"everyonelovessapient", "onlyilovesapient"};
        final String[] expectedOutputs = {"everyone loves sapient", "only i love sapient"};

        boolean hasTestPassed = hasTestPassed(inputs, expectedOutputs);
        System.out.println(hasTestPassed ? "Test with Happy cases have Passed" : "Test with Happy cases have Failed");
    }

    private static boolean hasTestPassed(String[] inputs, String[] expectedOutputs) {
        boolean hasTestPassed = true;

        final WordBreak wordBreak = new WordBreak();
        for (int index = 0; index < inputs.length; index++) {
            final String actualResult = wordBreak.getSentences(inputs[index]);

            // System.out.println("Input: " + inputs[index] + ", actual output: " + actualResult);
            hasTestPassed = hasTestPassed && expectedOutputs[index].contentEquals(actualResult);
        }
        return hasTestPassed;
    }
}
