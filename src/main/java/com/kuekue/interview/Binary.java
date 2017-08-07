package com.kuekue.interview;

public class Binary {

    public static void intToBinary() {

    }

    public static long ipToInt(String ip) {
        String[] ips = ip.split("\\.");
        int first = Integer.parseInt(ips[0]);
        int second = Integer.parseInt(ips[1]);
        int third = Integer.parseInt(ips[2]);
        int four = Integer.parseInt(ips[3]);
        double re =
                Math.pow(first, 4) * Math.pow(second, 3) * Math.pow(third, 2) * Math.pow(four, 1);
        return Math.round(re);
    }

    // public static String ipToInt2(String ip) {
    // String[] ips = ip.split("\\.");
    // int first = Integer.parseInt(ips[0]) - 128;
    // int second = Integer.parseInt(ips[1]) - 128;
    // int third = Integer.parseInt(ips[2]) - 128;
    // int four = Integer.parseInt(ips[3]) - 128;
    //
    // String binary = makeItFull(Integer.toBinaryString(first), first)
    // + makeItFull(Integer.toBinaryString(second))
    // + makeItFull(Integer.toBinaryString(third))
    // + makeItFull(Integer.toBinaryString(four));
    // System.out.println(binary);
    // return Long.valueOf(binary, 2).toString();
    // }

    public static String makeItFull(String text, int value) {

        if (value < 0) {

        }

        String result = text;
        while (result.length() < 8) {
            result = "0" + text;
        }
        return result;
    }

    private static void toNBigit(int data, int a) {
        if (a > 36 || a < 2) {
            System.out.println("不支持此进制！！！");
            return;
        }
        if (data < 0) {
            data = ((-1 * data) ^ ((1 << 31) - 1)) + 1;// 将负数变为正数,再取反（^((1<<31)-1)即为取反）,最后再加1；
        }
        int n = (data % a);
        int m = (data / a);

        if (m == 0) {
            printNBigitNum(n);
        } else {
            toNBigit(m, a);

            printNBigitNum(n);
        }
    }

    private static void printNBigitNum(int n) {
        if (n > 9 && n <= 36) {
            System.out.print((char) ((n - 10) + 65));
        } else if (n > 36) {
            System.out.println("不支持此进制！！！");
            return;
        } else {
            System.out.print(n);
        }
    }

    public static void main(String[] args) {

        String ip = "255.255.255.255";

        // System.out.println(ipToInt(ip));
        // System.out.println(Long.MAX_VALUE);
        // System.out.println(Math.round(Math.pow(256, 4)));

        // System.out.println(Integer.toBinaryString(-128));
        // System.out.println(Long.valueOf(Integer.toBinaryString(-128), 2));
        //
        // System.out.println("2 pow 31 - 1:" + (Math.round(Math.pow(2, 31)) - 1));
        // System.out.println("int max value:" + Integer.MAX_VALUE);
        // System.out.println("2 pow 31 - 1:" + (Math.round(Math.pow(-2, 31))));
        // System.out.println("int min value:" + Integer.MIN_VALUE);
        // System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        // byte[] bytes = intToByteArray(Integer.MAX_VALUE);
        // for (int i = 0; i < bytes.length; i++) {
        // System.out.println(bytes[i]);
        // }
        // System.out.println(byteArrayToInt(bytes));
        //
        // System.out.println(ipToInt3(ip));

        // System.out.println(Integer.MAX_VALUE >> 24);
        // System.out.println(Math.round(Math.pow(2, 8)) >> 1);
        System.out.println(-256 >>> 1);
    }

    private static int ipToInt3(String ip) {

        String[] ips = ip.split("\\.");
        int first = Integer.parseInt(ips[0]);
        int second = Integer.parseInt(ips[1]);
        int third = Integer.parseInt(ips[2]);
        int four = Integer.parseInt(ips[3]);

        byte[] bytes = new byte[4];
        bytes[0] = (byte) ((first >> 1) & 0xFF);
        bytes[1] = (byte) ((second >> 2) & 0xFF);
        bytes[2] = (byte) ((third >> 3) & 0xFF);
        bytes[3] = (byte) ((four >> 4) & 0xFF);

        return byteArrayToInt(bytes);
    }

    public static int byteArrayToInt(byte[] b) {
        return b[3] & 0xFF | (b[2] & 0xFF) << 8 | (b[1] & 0xFF) << 16 | (b[0] & 0xFF) << 24;
    }

    public static byte[] intToByteArray(int a) {
        return new byte[] {(byte) ((a >> 24) & 0xFF), (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF), (byte) (a & 0xFF)};
    }

}
