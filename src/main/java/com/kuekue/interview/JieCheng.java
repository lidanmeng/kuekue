package com.kuekue.interview;

import java.math.BigDecimal;

public class JieCheng {

    public static void jieCheng(long i) {

        long result = 1;
        for (long j = 1; j <= i; j++) {
            result = j * result;
        }
        System.out.println(result);
    }

    public static long zeroCount(long n) {

        int five = 1;
        while (true) {
            if (n <= Math.pow(5, five)) {
                break;
            }
            five++;
        }

        long result = 0;
        for (int i = 1; i <= five; i++) {
            result += n / Math.pow(5, i);
        }

        return result;
    }

    public static int fiveCiMi(long n) {
        int five = 1;
        while (true) {
            if (n <= Math.pow(5, five)) {
                return five;
            }
            five++;
        }
    }

    public static long zeroCount2(long n) {

        long s = 0;

        while (n > 0)

        {

            s = s + n / 5; // 每5个连续整数中就有一个5的倍数

            n = n / 5; // 每25个连续整数中就有一个25的倍数，…………

        }
        return s;

    }

    public static void main(String[] args) {
        System.out.println(zeroCount2(29191991000000000L));
    }

}
