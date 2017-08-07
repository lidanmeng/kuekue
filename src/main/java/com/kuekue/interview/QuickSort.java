package com.kuekue.interview;

public class QuickSort {

    public static void quickSort(int[] a, int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            return;
        }

        int p = a[startIndex];

        int i = startIndex, j = endIndex;

        while (i < j) {

            while (i < j && a[j] >= p) {
                j--;
            }
            if (i >= j) {
                break;
            }
            a[i] = a[j];

            while (i < j && a[i] <= p) {
                i++;
            }
            if (i >= j) {
                break;
            }
            a[j] = a[i];
        }

        a[j] = p;

        System.out.println("i:" + i + ",j:" + j + ",a:");

        if (j > 0) {
            quickSort(a, startIndex, j - 1);
            quickSort(a, j + 1, endIndex);
        }

    }


    public static void main(String[] args) {
        int[] a = {22, 33, 44, 7, 8, 3, 2, 5, 8, 2, 3, 42, 4, 2, 42, 45, 64, 74, 68, 79, 5, 9, 67,
                89, 69, 67, 53, 6, 45, 34, 563, 45, 6};
        quickSort(a, 0, a.length - 1);
        for (int c : a) {
            System.out.println(c);
        }
    }
}

