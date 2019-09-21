package com.sumansaurabh.ps.tesco;

import java.util.*;

public class EmailThread {

    private static final String EMAILS_PATTERN = "---";

    public static List<List<Integer>> getEmailThreads(List<String> emails) {
        List<String> parsedEmails = parseEmail(emails);
        Map<String, List<Integer>> bodyThreadIdMap = new LinkedHashMap<>();
        List<List<Integer>> threadIdPositionLists = new ArrayList<>();

        int threadId = 1;

        for (String email : parsedEmails) {
            if(email == null || email.trim().length()==0){
                continue;
            }
            if (!email.contains(EMAILS_PATTERN)) {
                List<Integer> threadIdPositionList = getThreadIdPositionList(threadId, 1);
                bodyThreadIdMap.put(email.trim(), threadIdPositionList);
                threadId++;
            } else {
                String[] bodies = email.split(EMAILS_PATTERN);
                int firstIndexOfPattern = email.indexOf(EMAILS_PATTERN);
                String content = email.substring(firstIndexOfPattern+EMAILS_PATTERN.length(), email.length());
                System.out.println(content);

                List<Integer> threadIdPositionList = bodyThreadIdMap.get(content);
                bodyThreadIdMap.put(email, getThreadIdPositionList(threadIdPositionList.get(0), bodies.length));
            }
        }

        for (Map.Entry<String, List<Integer>> entry : bodyThreadIdMap.entrySet()) {
            System.out.println(entry.getKey() + "-->"+ entry.getValue().toString());
            threadIdPositionLists.add(entry.getValue());
        }

        return threadIdPositionLists;
    }

    static List<Integer> getThreadIdPositionList(int threadId, int position) {
        List<Integer> list = new ArrayList<>();
        list.add(threadId);
        list.add(position);

        return list;
    }

    static List<String> parseEmail(List<String> emails){
        List<String> parsedEmails = new ArrayList<>();
        for(String email : emails){
            int position = email.indexOf(", ", email.indexOf(", ") + 1);
            if(position == -1){
                continue;
            }
            parsedEmails.add(email.substring(position+2, email.length()));
        }

        return parsedEmails;
    }


    public static void main(String[] args) {
        List<String> emails = Arrays.asList(
                "abc@gmail.com, x@gmail.com, hello x, how are you?",
                "abc@gmail.com, x@gmail.com,,,,",
                "c@gmail.com, abc@gmail.com, did you take a look at the event?",
                "x@gmail.com, abc@gmail.com, i am great. how are you?---hello x, how are you?");

//        List<String> emails = Arrays.asList(
//                "aupx@hackerrank.com, gyaxjzbfp@hackerrank.com, xo qnjxde, ur",
//                "ysg@gmail.com, moffx@outlook.com, l",
//                "uil@outlook.com, gyaxjzbfp@hackerrank.com, zdyc",
//                "moffx@outlook.com, ysg@gmail.com, zh---l",
//                "uil@outlook.com, gyaxjzbfp@hackerrank.com, pm---zdyc",
//                "gyaxjzbfp@hackerrank.com, aupx@hackerrank.com, xou---xo qnjxde, ur",
//                "moffx@outlook.com, ysg@gmail.com, s---zh---l",
//                "gyaxjzbfp@hackerrank.com, uil@outlook.com, f---pm---zdyc",
//                "gyaxjzbfp@hackerrank.com, uil@outlook.com, j---f---pm---zdyc");


        List<List<Integer>> results = getEmailThreads(emails);
        for (List<Integer> value : results) {
            System.out.println(value.get(0) + " " + value.get(1));
        }
    }
}
