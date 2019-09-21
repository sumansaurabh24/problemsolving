package com.sumansaurabh.ps.strings;

public class LargestSubstringWithSameCharacter {

    public static int substring(String s){
        int answer = 1, temp = 1;

        int stringLength = s.length();

        for(int i = 1; i < stringLength; i++){

            if(s.charAt(i) == s.charAt(i-1)){
                ++temp;
            }else {
                answer = Math.max(answer, temp);
                temp = 1;
            }
        }

        answer = Math.max(answer, temp);
        return answer;
    }

    public static void main(String[] args) {
        String s = "abcddddefffffffffff";
        System.out.println(substring(s));
    }
}
