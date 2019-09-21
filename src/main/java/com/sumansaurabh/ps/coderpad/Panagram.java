package com.sumansaurabh.ps.coderpad;

public class Panagram {

    static final String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";

    static String findMissing(String s){
        boolean mark[] = new boolean[26];
        int index = 0;

        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' ){
                index = s.charAt(i) - 'A';
            }else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                index = s.charAt(i) - 'a';
            }

            mark[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < mark.length ; i++){
            if (mark[i] == false){
                sb.append(ALPHABETS.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "The quick brown fox jumps over the lazy dog";
        String missing = findMissing(s);
        System.out.println(missing);
    }
}
