package com.kuekue.interview;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * find the first char that only appears once in a string
 * 
 * @author Administrator
 *
 */

public class FirstCharAppearOnce {

	public static void main(String[] args) {

		String a = "ndabastadmaagada";

		String b = firstCharAppearOnce(a);

		System.out.println(b);
	}

	private static String firstCharAppearOnce(String a) {

		char[] array = a.toCharArray();

		Set<String> set = new HashSet<String>();
		Set<String> exist = new HashSet<String>();

		for (int i = 0; i < array.length; i++) {

			String k = String.valueOf(array[i]);

			if (exist.contains(k)) {
				continue;
			}

			if (set.contains(k)) {
				set.remove(k);
				exist.add(k);
				continue;
			}
			set.add(k);
		}

		return set.iterator().next();
	}

}
