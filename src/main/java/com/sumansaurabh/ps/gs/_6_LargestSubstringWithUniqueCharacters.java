package com.prep.coderpad;

import java.util.HashMap;
import java.util.Map;

public class _6_LargestSubstringWithUniqueCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "aaabcbdeafapoiuytrewq";
		String maxLengthWord = "";
		String maxWord = new String();
		Map map = new HashMap();
		int countLoops=0;
		for (int i = 0; i < test.length(); i++) {
			if (!map.containsKey(test.charAt(i))) {
				maxWord = maxWord + test.charAt(i);
				map.put(test.charAt(i), i);
			} else {
				i = (int)map.get(test.charAt(i))+1;
				map.clear();
				if (maxWord.length() > maxLengthWord.length()) {
					maxLengthWord = maxWord.toString();

				}
				maxWord = "";
			}
			System.out.println(++countLoops);
		}
		if (maxWord.length() > maxLengthWord.length()) {
			maxLengthWord = maxWord.toString();
		}
		
		System.out.println(maxLengthWord);
		System.out.println(substring(test));
	}

	public static String substring(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		char[] ch = str.toCharArray();
		int max = 0;
		int countLoops=0;
		int start = 0;
		for (int i = 0; i < ch.length;) {
			int index = i;
			int len = 0;
			while (i < ch.length && !map.containsKey(ch[i])) {
				map.put(ch[i], i);
				len++;
				i++;
				System.out.println(++countLoops);
			}

			if (max < len) {
				max = len;
				start = index;
			}

			if (i < ch.length) {
				i = map.get(ch[i]) + 1;
			}
			map.clear();
		}

		return str.substring(start, start + max);

	}

}
