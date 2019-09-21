package com.sumansaurabh.ps.strings;

import java.util.Map;

public class MagicPotion {

    static int minimalSteps(String s){

        int index = 1;

        for(int i = 1; i < s.length(); i++){
            String temp = s.substring(0, i) ;
            if(s.contains(temp)){
                continue;
            }else{

            }
        }
        return -1;
    }




    public static void main(String[] args) {
        String s = "ABABCABABCE";
        int length = minimalSteps(s);
        System.out.println("Minimal steps :" + length);
    }
}
