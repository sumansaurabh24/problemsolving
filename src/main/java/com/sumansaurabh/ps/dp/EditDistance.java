package com.sumansaurabh.ps.dp;

public class EditDistance {

    static int minimum(int a , int b , int c){
        return Math.min(a, Math.min(b, c));
    }

    static int dist(String s1, int s1Length , String s2, int s2Length){

        if(s1Length == 0){
            return s2Length;
        }

        if(s2Length == 0){
            return s1Length;
        }

        int cost = (s1.charAt(s1Length - 1) == s2.charAt(s2Length-1)) ? 0 : 1;

        return minimum(
                dist(s1, s1Length - 1, s2, s2Length) + 1, //deletion
                dist(s1, s1Length, s2, s2Length -1) + 1 , // insertion
                dist(s1, s1Length-1, s2, s2Length -1) + cost // substitution
         );
    }

    public static void main(String[] args) {
        String s1 = "kitten";
        String s2 = "sitting";

        int distance = dist(s1, s1.length(), s2, s2.length());

        System.out.println("Distance : " + distance);
    }
}
