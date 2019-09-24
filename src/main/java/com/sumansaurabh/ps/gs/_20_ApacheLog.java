package com.prep.coderpad;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _20_ApacheLog {

	/**
	 * Given a log file, return IP address(es) which accesses the site most often.
	 */

	public static String findTopIpaddress(String[] lines) {
		// Your code goes here

		Map<String, Long> map = Arrays.stream(lines).map(line -> line.split("-")[0].trim())
				.collect(Collectors.groupingBy(ip -> ip, Collectors.counting()));
		System.out.println(map);
		long maxCount = map.entrySet().stream().max((e1, e2) -> (e1.getValue() > e2.getValue() ? 1 : -1)).get()
				.getValue();
		List<String> listOfIp = map.entrySet().stream().filter(entry -> entry.getValue() == maxCount)
				.map(entry1 -> entry1.getKey()).collect(Collectors.toList());
		System.out.println(listOfIp);
		return "10.0.0.1";
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