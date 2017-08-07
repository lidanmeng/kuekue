package com.kuekue.interview.extents;

public class Doctor extends Person {

    private static int i = 100;

    static {
        System.out.println(i++);
        System.out.println("doctor static born");
    }

    public void say() {
        System.out.println(++i);
        System.out.println("doctor say ....");
    }


    public static void main(String[] args) {
        Person p = new Doctor();
        p.say();

        int i = 1;
        for (;;) {
            System.out.println(i++);
            if (i > 100) {
                break;
            }
        }
    }

}
