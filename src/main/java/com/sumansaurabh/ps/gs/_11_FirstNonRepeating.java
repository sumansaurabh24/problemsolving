package com.prep.coderpad;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _11_FirstNonRepeating {

  /**
  * Finds the first character that does not repeat anywhere in the input string
  * Given "apple", the answer is "a"
  * Given "racecars", the answer is "e"
  **/        
  public static char findFirst(String input)
  {
    // code goes here
	 //Stream<Character> charStream=input.chars().mapToObj(l->(char)l);
	 //System.out.println(charStream.collect(Collectors.groupingBy(l->l,Collectors.counting())).entrySet().stream().min((e1,e2)->e1.getValue()>e2.getValue()?1:-1).get().getKey());
	  Map map = new LinkedHashMap();
	  
	  for(int index=0;index<input.length();index++) {
		  if (map.containsKey(input.charAt(index))) {
			  map.put(input.charAt(index), (int)map.get(input.charAt(index))+1);
		  }else {
			  map.put(input.charAt(index), 1);
		  }
	  }
	  
	  List l1=(List)map.keySet().stream().filter(l->((int)map.get(l)==1)).
			  collect(Collectors.toList());
		System.out.println("Test"+l1.get(0));
		
	  Iterator it=map.keySet().iterator();
	  while(it.hasNext()) {
		  char s=(char)it.next();
		  if((int)map.get(s)==1) {
			  return s;
		  }
	  }
	  
		//System.out.println(result);
    return( ' ' );
  }

  public static void main(String args[])
  {

    String[] inputs = {"apple","racecars", "ababdc"};
    char[] outputs = {'a', 'e', 'd' };

    boolean result = true;
    for(int i = 0; i < inputs.length; i++ )
    {
      result = result && findFirst(inputs[i]) == outputs[i];
      if(!result)
        System.out.println("Test failed for: " + inputs[i]);
      else
        System.out.println("Test passed for: " + inputs[i]);
    }
  }

}
