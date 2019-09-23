package com.sumansaurabh.ps.gs;

import java.util.HashSet;
import java.util.Set;

public class LongestSubtringWithoutRepeatingCharacters {

    static int findLongest(String s){
        if(s == null || s.length() == 0){
            return 0;
        }

        Set<Character> characterSet = new HashSet<>();

        int left = 0;
        int right = 0;
        int max = 0;

        while (right < s.length()){
            if(characterSet.add(s.charAt(right))){
                right++;
                max = Math.max(max, right - left);
            }else{
                characterSet.remove(s.charAt(left++));
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "pwwke";
        int length = findLongest(s);
        System.out.println(length);
    }
}
