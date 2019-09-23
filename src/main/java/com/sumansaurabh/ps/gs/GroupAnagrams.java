package com.sumansaurabh.ps.gs;

import java.util.*;

public class GroupAnagrams {

    static List<String> setOfAnagrams(String s){
        String[] words = s.split(" ");
        Map<String, List<String>> anagramsMap = new LinkedHashMap<>();
        List<String> returnList = new ArrayList<>();

        Arrays.stream(words).forEach(word -> {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            //find in map
            List<String> wordList = anagramsMap.get(sortedWord);

            if(wordList == null){
                wordList = new ArrayList<>();
                wordList.add(word);
                anagramsMap.put(sortedWord, wordList);
            }else {
                wordList.add(word);
            }
        });

        anagramsMap.forEach((k, v) -> {
            returnList.addAll(v);
        });

        return returnList;
    }

    public static void main(String[] args) {
        String s = "cat dog tac sat tas god dog";
        for(String str: setOfAnagrams(s)){
            System.out.print(str + " ");
        }
    }
}
