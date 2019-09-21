package com.sumansaurabh.ps.strings;

import java.util.*;

public class GroupAnagram {

    static List<String> setOfAnagrams(String s){
        String[] words = s.split(" ");
        Map<String, List<String>> wordMap = new LinkedHashMap<>();
        List<String> resultList = new ArrayList<>();

        for(String word: words){
            char[] charSequence = word.toCharArray();
            Arrays.sort(charSequence);
            String sortedWord = new String(charSequence);

            List<String> wordList = wordMap.get(sortedWord);

            if(wordList == null){
                wordList = new ArrayList<>();
                wordList.add(word);
                wordMap.put(sortedWord, wordList);
            }else {
                wordList.add(word);
            }
        }

        for (Map.Entry<String, List<String>> entry: wordMap.entrySet()){
            resultList.addAll(entry.getValue());
        }

        return resultList;
    }

    public static void main(String[] args) {
        String s = "cat dog tac sat tas god dog";
        for(String str: setOfAnagrams(s)){
            System.out.print(str + " ");
        }
    }
}
