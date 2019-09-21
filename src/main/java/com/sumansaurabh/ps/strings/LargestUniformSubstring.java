package com.sumansaurabh.ps.strings;

public class LargestUniformSubstring {

    static Index largestSubstring(String input){
        int stringLength = input.length();

        int maxLength = 1, currentLength = 1;
        Index index = new Index();

        for(int i = 0; i < stringLength ; i++){

            if(input.charAt(i) == input.charAt(i+1)){
                if(index.isFirstVisit == false){
                    index.start = i;
                }
                currentLength++;
            }else{

            }
        }

        return null;
    }

    public static void main(String[] args) {
        String input = "abcdefffff";
        Index index = largestSubstring(input);
        System.out.println(input.substring(index.start, index.end));
    }
}
class Index{
    int start;
    int end;
    boolean isFirstVisit;
}
