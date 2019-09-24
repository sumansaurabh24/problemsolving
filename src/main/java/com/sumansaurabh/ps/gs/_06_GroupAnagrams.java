package com.prep.coderpad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * This program prints set of anagrams together in given string 
 * 
 * eg. 
 * setOfAnagrams("cat dog tac sat tas god dog") should print "cat tac dog god dog sat tas"
 *
 */

class _06_GroupAnagrams {
  
  static String input = "cat dog tac sat tas god dog";
  
  static void setOfAnagrams(String inputString){ 
    
    String [] inputArray=inputString.split(" ");
    Map<String,List> map= new LinkedHashMap();
    Stream.of(inputArray).forEach(l->{
    	char[] charArray=l.toCharArray();
    	Arrays.sort(charArray);
    	String s=String.valueOf(charArray);
    	if(map.containsKey(s)) {
    		map.get(s).add(l);
    	}else {
    		List list= new ArrayList();
    		list.add(l);
    		map.put(s, list);
    	}
    });
    List list1=(List)map.values().stream().
    		flatMap(list->list.stream().map(l1->l1)).
    		collect(Collectors.toList());
    System.out.println(list1.stream().reduce((x1,x2)->x1+" "+x2).get());
    
    
    
  }
  
  
  public static void main(String[] args) {
    
    String input = "cat dog tac sat tas god dog";
    setOfAnagrams(input);
    
  }
}