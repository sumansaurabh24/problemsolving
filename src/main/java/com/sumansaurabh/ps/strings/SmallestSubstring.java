package com.sumansaurabh.ps.strings;

import java.util.Arrays;

public class SmallestSubstring {

    static final int MAX_CHARS = 256;

    public static int shortestSubstring(String s) {
        int n = s.length();

        int distCount = 0;

        boolean[] visited = new boolean[MAX_CHARS];
        Arrays.fill(visited, false);
        for (int i=0; i<n; i++)
        {
            if (visited[s.charAt(i)] == false)
            {
                visited[s.charAt(i)] = true;
                distCount++;
            }
        }

        int start = 0, startIndex = -1;
        int minLen = Integer.MAX_VALUE;

        int count = 0;
        int[] curr_count =  new int[MAX_CHARS];
        for (int j=0; j<n; j++)
        {

            curr_count[s.charAt(j)]++;


            if (curr_count[s.charAt(j)] == 1 ) {
                count++;
            }


            if (count == distCount)
            {

                while (curr_count[s.charAt(start)] > 1)
                {
                    if (curr_count[s.charAt(start)] > 1)
                        curr_count[s.charAt(start)]--;
                    start++;
                }


                int windowLength = j - start + 1;
                if (minLen > windowLength)
                {
                    minLen = windowLength;
                    startIndex = start;
                }
            }
        }

        return s.substring(startIndex, startIndex+minLen).length();
    }


    public static void main(String[] args) {
        String str = "bcaacbc";
        System.out.println("Smallest window containing all distinct"
                + " characters is " + shortestSubstring(str));
    }

}
