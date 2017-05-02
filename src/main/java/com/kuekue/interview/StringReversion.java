package com.kuekue.interview;

public class StringReversion {

	public static void main(String[] args) {

		String a = "abcdefghijklmn";

		String b = reversion(a, 0);

		System.out.println(b);

	}

	private static String reversion(String a, int index) {

		int start = index + 1;
		int end = a.length() - 1 - index;

		if (start <= end) {
			a = a.substring(0, start - 1) + a.substring(end, end + 1) + a.substring(start, end)
					+ a.substring(start - 1, start) + a.substring(a.length() - index, a.length());
			System.out.println(a);
			return reversion(a, index + 1);
		} else {
			return a;
		}
	}

}
