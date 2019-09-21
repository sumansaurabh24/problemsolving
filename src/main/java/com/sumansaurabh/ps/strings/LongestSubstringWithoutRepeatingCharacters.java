package com.sumansaurabh.ps.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    static void longestSubstring(String s){
        char[] charSequence = s.toCharArray();
        int longestSubstringLength = 0;
        String longestSubstring = null;

        Map<Character, Integer> charPosMap = new LinkedHashMap<>();

        for(int i = 0; i < charSequence.length; i++){

            if(!charPosMap.containsKey(charSequence[i])){
                charPosMap.put(charSequence[i], i);
            }else{
                i = charPosMap.get(charSequence[i]);
                charPosMap.clear();
            }

            if(charPosMap.size() > longestSubstringLength){
                longestSubstringLength = charPosMap.size();
                longestSubstring  = charPosMap.keySet().toString();
            }
        }

        System.out.println("Input String : " +  s);
        System.out.println("Longest Substring : " + longestSubstring);
        System.out.println("Longest Substring Length : " + longestSubstringLength);
    }

    public static void main(String[] args) {
        String s = "javaconceptoftheday";
        longestSubstring(s);
    }
}
