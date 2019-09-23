package com.sumansaurabh.ps.gs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RunLengthEncoding {

    static String encode(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length() - 1; i++) {
            int count = 1;

            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }

            sb.append(s.charAt(i)).append(count);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Map<String, String> testCaseMap = new LinkedHashMap<>();

        testCaseMap.put("", "");
        testCaseMap.put(null, "");
        testCaseMap.put(" ", "");
        testCaseMap.put("aabbb", "a2b3");
        testCaseMap.put("wwwwaaadexxxxxxywww", "w4a3d1e1x6y1w3");

        testCaseMap.forEach((k, v) -> {
            String encodedString = encode(k);
            if(encodedString.equals(v)){
                System.out.println("Test Passed");
            }else{
                System.out.println("Test Failed");
            }
        });

    }
}
