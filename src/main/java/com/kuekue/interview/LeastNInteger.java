package com.kuekue.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * there are n integers , write a program to find out the least K integers among
 * the n
 * 
 * @author Administrator
 *
 */
public class LeastNInteger {

	private static final int K = 4;

	public static void main(String[] args) {

		Integer[] ints = { 34, 56, 6, 7, 2, 98, 35, 22 };

		Integer[] leasts = leastIntegers(ints);

		for (Integer i : leasts) {
			System.out.println(i);
		}

	}

	private static Integer[] leastIntegers(Integer[] ints) {

		Integer[] array = new Integer[K];

		int kMax = 0, kIndex = 0;

		for (Integer i = 0; i < ints.length; i++) {

			kMax = 0;
			kIndex = 0;

			if (i < K) {
				array[i] = ints[i];
				continue;
			}

			for (int j = 0; j < array.length; j++) {
				if (array[j] > kMax) {
					kMax = array[j];
					kIndex = j;
				}
			}
			if (ints[i] < kMax) {
				array[kIndex] = ints[i];
			}
		}

		return array;
	}

}
