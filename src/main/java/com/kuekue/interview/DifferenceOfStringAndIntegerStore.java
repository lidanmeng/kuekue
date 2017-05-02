package com.kuekue.interview;

public class DifferenceOfStringAndIntegerStore {

	public static void main(String[] args) {

		long init = Runtime.getRuntime().freeMemory();
		System.out.println(init);

		int i = 100000000;

		long intCost = Runtime.getRuntime().freeMemory();
		System.out.println("cost:" + (intCost - init));

		String j = String.valueOf(i);
		long stringCost = Runtime.getRuntime().freeMemory();

		System.out.println("cost:" + (stringCost - intCost));
	}

}
