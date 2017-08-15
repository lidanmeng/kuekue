package com.kuekue.interview;

public class NThNodeFromLast {

    static class Node {

        String data;

        Node next;

        public Node(String data) {
            this.data = data;
        }

    }

    static int n = 50;

    public static void getNthNodeFromLast(Node first) {

        int pos = 0;
        Node result = null;

        Node current = first;
        while (current != null) {

            if (pos >= n) {
                result = result == null ? first : result.next;
            }
            pos++;
            current = current.next;
        }
        System.out.println(result.data);
    }

    public static void main(String[] args) {

        Node first = new Node("data0");

        Node prev = first;
        for (int i = 1; i <= 100; i++) {
            Node node = new Node("data" + i);
            prev.next = node;
            prev = node;
        }

        getNthNodeFromLast(first);
    }

}
