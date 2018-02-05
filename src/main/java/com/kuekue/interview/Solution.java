package com.kuekue.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Solution {
    /*
     * @param : An integer
     * 
     * @param : An integer
     * 
     * @return: An integer denote the count of digit k in 1..n
     */
    public static int digitCounts(int k, int n) {
        // write your code here
        int wei = String.valueOf(n).length();

        // if (n >= (k + 1) * Math.pow(10, wei - 1)) {
        // return everyWeiCount(wei);
        // }

        int result = 0;
        for (int i = 0; i < wei; i++) {
            int value = Integer.parseInt(String.valueOf(n).substring(i, i + 1));

            result += (value + 1) * digitCountsEveryWeiCount(wei - 1 - i);



        }
        return result;
    }

    public static int digitCounts2(int k, int n) {
        return 0;
    }

    /**
     * 下一个丑数
     * 
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        return 0;
    }

    /**
     * 合并两个有序数组
     * 
     * @param a
     * @param b
     * @return
     */
    public static int[] mergeSortedArray(int[] A, int[] B) {

        int[] result = new int[A.length + B.length];

        int aLength = A.length, bLength = B.length;
        int aIndex = 0, bIndex = 0;

        for (int i = 0; i < result.length; i++) {

            if (aIndex == aLength) {
                result[i] = B[bIndex];
                bIndex++;
                continue;
            }

            if (bIndex == bLength) {
                result[i] = A[aIndex];
                aIndex++;
                continue;
            }

            if (A[aIndex] >= B[bIndex]) {
                result[i] = B[bIndex];
                bIndex++;
            } else {
                result[i] = A[aIndex];
                aIndex++;
            }
        }

        return result;
    }

    public boolean isUglyNumber(int n) {
        char[] nStr = String.valueOf(n).toCharArray();
        int sum = 0;
        for (int i = 0; i < nStr.length; i++) {
            sum += Integer.parseInt(nStr.toString());
        }
        return sum % 3 == 0;
    }

    public static int digitCountsEveryWeiCount(int i) {

        if (i <= 0) {
            return 1;
        }

        if (i == 1) {
            return 1;
        }

        if (i == 2) {
            return 20;
        }

        int result = 20;

        for (int j = 3; j <= i; j++) {
            result = (int) (result * Math.pow(10, j - 2) + Math.pow(10, j - 1));
        }


        return result;
    }

    /**
     * 旋转字符串
     * 
     * @param str
     * @param offset
     */
    public static void rotateString(char[] str, int offset) {
        // write your code here

        if (String.valueOf(str).equals("")) {
            return;
        }

        char[] result = new char[str.length];

        if (offset > str.length) {
            offset = offset % str.length;
        }

        int startIndex = str.length - offset;

        for (int i = 0; i < str.length; i++) {

            int index = startIndex + i >= str.length ? startIndex + i - str.length : startIndex + i;

            result[i] = str[index];

        }

        for (int i = 0; i < result.length; i++) {
            str[i] = result[i];
        }
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
        // write your code here
        int middle = (start + end) / 2;

        if (target == nums[middle]) {
            while (middle > 0 && nums[middle - 1] == target) {
                middle--;
            }
            return middle;
        }

        if (start == end) {
            return -1;
        }

        if (target > nums[middle]) {
            return binarySearch(nums, middle + 1, end, target);
        } else {
            return binarySearch(nums, start, middle - 1, target);
        }

    }

    public static List<List<Integer>> threeSum(int[] numbers) {

        int length = numbers.length;

        List<List<Integer>> lsit = new ArrayList<List<Integer>>();

        Set<String> set = new HashSet<String>();

        if (length < 3) {
            return lsit;
        }

        for (int i = 0; i < length; i++) {

            for (int j = i + 1; j < length; j++) {

                if (i == j) {
                    continue;
                }

                for (int k = j + 1; k < length; k++) {

                    if (k == i || k == j) {
                        continue;
                    }

                    if (numbers[i] + numbers[j] + numbers[k] == 0) {
                        List<Integer> kick = Arrays.asList(numbers[i], numbers[j], numbers[k]);
                        Collections.sort(kick);
                        String temp = kick.get(0) + "," + kick.get(1) + "," + kick.get(2);
                        if (set.contains(temp)) {
                            continue;
                        }
                        lsit.add(kick);
                        set.add(temp);
                    }
                }

            }

        }

        return lsit;
    }

    /**
     * Definition for ListNode .
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }


    public static ListNode reverse(ListNode head) {
        // write your code here

        if (head == null) {
            return null;
        }

        List<Integer> list = new ArrayList<Integer>();

        ListNode next = head;
        for (;;) {
            if (null != next) {
                list.add(next.val);
                next = next.next;
                continue;
            }
            break;
        }

        ListNode newHead = new ListNode(list.get(list.size() - 1));

        ListNode node = null;
        ListNode prev = null;
        for (int i = (list.size() - 1); i >= 0; i--) {
            if (node == null) {
                node = newHead;
                prev = newHead;
                continue;
            }

            node = new ListNode(list.get(i));
            prev.next = node;
            prev = node;

        }

        return newHead;
    }

    public static int majorityNumber(List<Integer> nums) {

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (Integer integer : nums) {
            map.put(integer, map.get(integer) == null ? 1 : map.get(integer) + 1);
        }

        List<Map.Entry<Integer, Integer>> list =
                new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        return list.get(list.size() - 1).getKey();
    }

    public static int majorityNumber2(List<Integer> nums) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer integer : nums) {
            map.put(integer, map.get(integer) == null ? 1 : map.get(integer) + 1);
        }

        int half = nums.size() / 2;
        for (Integer key : map.keySet()) {
            if (map.get(key) > half) {
                return key;
            }
        }
        return 0;
    }

    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here

        ListNode newHead = null;

        ListNode node = null;
        ListNode prev = null;

        int nil = 0;
        while (true) {

            nil = 0;

            Integer min = null, minIndex = null;
            ListNode minHead = null;
            for (int i = 0; i < lists.size(); i++) {

                ListNode current = lists.get(i);
                if (current == null) {
                    nil++;
                    continue;
                }
                if (min == null || current.val < min) {

                    min = current.val;
                    minIndex = i;
                    minHead = current;
                }
            }

            if (nil == lists.size()) {
                break;
            }

            if (newHead == null) {
                newHead = minHead;
            } else {
                if (node == null) {
                    node = newHead;
                    prev = newHead;
                    continue;
                }

                node = minHead;
                prev.next = node;
                prev = node;
            }



            lists.set(minIndex, lists.get(minIndex).next);
        }



        return newHead;
    }

    /**
     * 骰子
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        return null;

    }

    public static void main(String[] args) {

    }
};
