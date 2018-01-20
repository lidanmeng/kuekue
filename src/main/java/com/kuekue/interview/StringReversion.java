package com.kuekue.interview;

public class StringReversion {

    public static void main(String[] args) {

        String a = "abcdefghijklmn";

        String b = reversion(a, 0);

        System.out.println(b);


        String c = "我是一名迷迷糊糊的程序员";
        Link link = new Link();
        for (int i = 0; i < c.length(); i++) {
            // System.out.println(c.substring(i, i + 1));
            link.add(c.substring(i, i + 1));
        }

        Node current = link.first;
        while (current.next != null) {
            current = current.next;
            System.out.println(current.data);
        }

        current = link.last;
        while (current.prev != null) {
            current = current.prev;
            System.out.println(current.data);
        }
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

    static class Link {

        Node first;

        Node last;

        public void add(String data) {
            Node node = new Node(data);
            if (first == null) {
                first = node;
                last = node;
                return;
            }

            if (first.next == null) {
                first.next = node;
                node.prev = first;
            }

            last.next = node;
            node.prev = last;
            last = node;
        }

    }

    static class Node {

        String data;

        Node prev;

        Node next;

        public Node(String data) {
            this.data = data;
        }



    }

}
