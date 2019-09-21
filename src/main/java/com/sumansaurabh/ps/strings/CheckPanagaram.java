package com.sumansaurabh.ps.strings;

public class CheckPanagaram {

    static boolean check(String s){

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

        for(int i = 0 ; i < mark.length ; i++){
            if (mark[i] == false){
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the laZ dog";
        boolean isPanagram = check(str);
        if(isPanagram){
            System.out.println(str + " is pangaram");
        }else{
            System.out.println(str + " is `not` panagram");
        }
    }
}
