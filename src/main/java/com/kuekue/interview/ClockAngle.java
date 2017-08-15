package com.kuekue.interview;

import java.text.DecimalFormat;

public class ClockAngle {

    public static String clockAngle(String input) {

        int hour = Integer.parseInt(input.split(":")[0]);
        int min = Integer.parseInt(input.split(":")[1]);
        int sec = Integer.parseInt(input.split(":")[2]);

        hour = hour >= 12 ? hour - 12 : hour;

        long hourSec = min * 60 + hour * 60 * 60 + sec;
        long minSec = min * 60 + sec;

        long cha = Math.abs(hourSec - 12 * minSec);

        DecimalFormat df = new DecimalFormat("0.0000");
        return df.format((float) cha / 120);

    }

    public static void main(String[] args) {
        System.out.println(clockAngle("8:00:00"));
    }
}
