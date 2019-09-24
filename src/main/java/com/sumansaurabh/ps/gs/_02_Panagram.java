package com.prep.coderpad;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Pangram FInder
 *
 * The sentence "The quick brown fox jumps over the lazy dog" contains every
 * single letter in the alphabet. Such sentences are called pangrams. Write a
 * function findMissingLetters, which takes a String `sentence`, and returns all
 * the letters it is missing
 *
 */
class _02_Panagram {

	private static class PanagramDetector {
		private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

		public String findMissingLetters(String sentence) {
			//Set<Character> missingCharacters = new TreeSet<Character>();
			sentence = sentence.toLowerCase();
			//Stream.of(ALPHABET.chars()).mapToObj(l->l).collect(Collectors.toSet());
			Set missingCharacters=ALPHABET.chars().mapToObj(l->(char)l).collect(Collectors.toSet());
			//Arrays.stream(array)

			/*for(int i=0;i<ALPHABET.length();i++) {
				missingCharacters.add(new Character(ALPHABET.charAt(i)));
			}*/
			for (int i = 0; i < sentence.length(); i++) {
					missingCharacters.remove(new Character(sentence.charAt(i)));
			}
			StringBuilder sb = new StringBuilder();
			missingCharacters.stream().forEach(l1 -> {
				sb.append(l1);
			});
			//System.out.println(sb);
			return sb.toString();
		}

	}

	public static void main(String[] args) {
		PanagramDetector pd = new PanagramDetector();
		boolean success = true;

		success = success && "".equals(pd.findMissingLetters("The quick brown fox jumps over the lazy dog"));
		success = success && "abcdefghijklmnopqrstuvwxyz".equals(pd.findMissingLetters(""));

		if (success) {
			System.out.println("Pass ");
		} else {
			System.out.println("Failed");
		}
	}
}