package com.prep.coderpad;
/*
Question: 
Combine ingredients in a specific order, any of which may be repeated

As an example, consider the following  
(A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, E 

Encode the string above using only 6 characters: A,B,*,C,*,E

Implement function that takes as input an un-encoded potion and returns the 
minimum number of characters required to encode

*/

public class _19_MagicPotion {
	private static int minimalSteps(String ingredients) {
		String ans = "";
		String intermediateIng = "";
		int i = 0;
		while (i < ingredients.length()) {
			if (intermediateIng.length() > 0 && (i + intermediateIng.length() < ingredients.length())
					&& ingredients.substring(i, i + intermediateIng.length()).equals(intermediateIng)) {
				ans = ans + "*";
				i = i + intermediateIng.length();
				intermediateIng = intermediateIng + intermediateIng;
				
				
			} else {
				ans = ans + ingredients.charAt(i);
				intermediateIng = intermediateIng + ingredients.charAt(i);
				i++;
			}
		}
		System.out.println(ans);
		return ans.length();
	}

	public static void main(String[] args) {

		if (minimalSteps("ABCDABCEFGH") == 11 && minimalSteps("ABCABCE") == 5 && minimalSteps("ABABCABABCE")==6) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
}