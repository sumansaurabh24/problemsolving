package com.prep.coderpad;
/*
 *					******** IMPORTANT ********
 *
 * THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
 * USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


class _24_BestAverageGrade
{
    public static Integer bestAverageGrade(String[][] inputScores)
    {
        if(inputScores.length == 0)
        {
            return 0;
        }
        Map<String,Float> scoreMap= new HashMap<String,Float>();
        Map<String,Integer> scoreCount= new HashMap<String,Integer>();
        for(int i=0;i<inputScores.length;i++) {
        	if(scoreMap.containsKey(inputScores[i][0])){
        		scoreMap.put(inputScores[i][0], scoreMap.get(inputScores[i][0])+Float.parseFloat(inputScores[i][1]));
        	}else {
        		scoreMap.put(inputScores[i][0], Float.parseFloat(inputScores[i][1]));
        	}
        	if(scoreCount.containsKey(inputScores[i][0])){
        		scoreCount.put(inputScores[i][0], (int)scoreCount.get(inputScores[i][0])+1);
        	}else {
        		scoreCount.put(inputScores[i][0], 1);
        	}
        }
        Iterator it=scoreMap.keySet().iterator();
        while(it.hasNext()) {
        	String name=(String) it.next();
        	scoreMap.put(name, scoreMap.get(name)/scoreCount.get(name));
        }
        float max=scoreMap.entrySet().stream().max((e1,e2)->e1.getValue()>e2.getValue()?1:-1).get().getValue();
        System.out.println(max);
        return (int)Math.floor(max);
//        System.out.println(scoreMap);
//		List l=new ArrayList(scoreMap.values());
//		Collections.sort(l)	;
//		int maxScore=(int)l.get(l.size()-1);
//		Iterator it1=scoreMap.keySet().iterator();
//		while(it1.hasNext()) {
//			String name=(String)it1.next();
//			if((int)scoreMap.get(name)==maxScore){
//				System.out.println(name);
//				break;
//			}
//		}
		
        
    }

    public static boolean doTestsPass()
    {
        Map<String[][], Integer> testCases = new HashMap<>();

        testCases.put(new String[][] { { "Bobby", "87" },
                        { "Charles", "100" },
                        { "Eric", "64" },
                        { "Charles", "22" } },
                87);
        testCases.put(new String[][] {},
                0);
        testCases.put(new String[][] { { "Sarah", "91" },
                        { "Goldie", "92" },
                        { "Elaine", "93" },
                        { "Elaine", "95" },
                        { "Goldie", "94" },
                        { "Sarah", "93" } },
                94);
        testCases.put(new String[][] { { "Janie", "-66" },
                        { "Janie", "0" },
                        { "Gina", "-88" },
                        { "Bobby", "0" },
                        { "Gina", "44" },
                        { "Bobby", "0" },
                        { "Bobby", "-6" } },
                -2);
        testCases.put(new String[][] { { "Alpha", "99" },
                        { "Bravo", "99" },
                        { "Charlie", "99" },
                        { "Delta", "99" },
                        { "Echo", "99" },
                        { "Foxtrot", "99" },
                        { "Foxtrot", "99" } },
                99);
        testCases.put(new String[][] { { "Gerald", "91" },
                        { "Gerald", "92" } },
                91);
        testCases.put(new String[][] { { "Barry", "-66" },
                        { "Barry", "-65" },
                        { "Alfred", "-122"} },
                -66);

        boolean passed = true;
        for(Map.Entry<String[][], Integer> entry : testCases.entrySet())
        {
            Integer actual = bestAverageGrade(entry.getKey());
            if(actual != entry.getValue())
            {
                passed = false;
                System.out.println("Failed for " + Arrays.deepToString(entry.getKey()) + "\n  expected " + entry.getValue() + ", actual " + actual);
            }
        }

        return passed;
    }

    public static void main(String[] args)
    {
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }
    }
}