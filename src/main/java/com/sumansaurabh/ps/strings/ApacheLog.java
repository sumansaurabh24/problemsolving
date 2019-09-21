package com.sumansaurabh.ps.strings;

import java.util.Arrays;

public class ApacheLog {

    static String findTopIpaddress(String[] lines){
        Arrays.stream(lines);
        return null;
    }

    public static void main(String[] args) {
        String lines[] = new String[] { "10.0.0.1 - log entry 1 11", "10.0.0.1 - log entry 2 213",
                "10.0.0.2 - log entry 133132", "10.0.0.2 - log entry 133132" };
        String result = findTopIpaddress(lines);

        if (result.equals("10.0.0.1")) {
            System.out.println("Test passed");

        } else {
            System.out.println("Test failed");

        }
    }
}
