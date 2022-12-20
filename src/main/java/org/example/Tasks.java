package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Tasks {

    /*
     * Звездочки
     *
     * Задача 1: Строка a2b3c5 после разжатия становится строкой aabbbccccc. Сделать encode/decode
     *
     * Задача 2: Есть 2 строки. В каждой известны какие-то символы. Если какие-то символы неизвестны,
     *           то они кодируются количеством этих символов. Т.е. если написано A5b, значит строка состоит
     *           из 7 символов, из которых известны только A и b, а все что между ними неизвестно.
     *           Проверить, могут ли две данные строки быть равны.
     * */
    public static String encode(String inputString) {
        return "";
    }


    /*
    * Count frequencies in an array {1, 2, 1, 1, 3, 2, 1, 4, 2, 2, 3, 4}
    *
    * */
    public static void countFrequencies(int[] nums) {
        int maxElem = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxElem) {
                maxElem = nums[i];
            }
        }
        int[] freqs = new int[maxElem + 1];
        for (int i = 0; i < nums.length; i++) {
            freqs[nums[i]]++;
        }
//        System.out.println(freqs);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(freqs[i]);
//        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxFreq = nums.length;
        while (maxFreq > 0) {
            map.put(maxFreq, new ArrayList<>());
            maxFreq--;
        }
        for (int i = 1; i < freqs.length; i++) {
            int currFreq = freqs[i];
            List<Integer> list = map.get(currFreq);
            list.add(i);
        }
        /*for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            System.out.println("key: " + entry.getKey() +
                    "; value:" + entry.getValue());
        }*/
        int count = 3;
        for (int j = 12;  j > 0; j--) {
            List<Integer> list = map.get(j);
            if (!list.isEmpty() && count > 0) {
                System.out.println(list);
                count--;
            }
        }

    }


    /*
    *
    * */
    public static boolean isValidSequence(String[] parentheses) {
        if (parentheses == null) return false;
        String firstElem = parentheses[0];
        if (firstElem.equals(")") || firstElem.equals("}")
                || firstElem.equals("]"))
            return false;

        Deque<String> stack = new LinkedList<>();
        for (String s: parentheses) {

            if (s.equals("(") || s.equals("{") || s.equals("[")) {
                stack.push(s);
            } else {
                String last = stack.pop();
                if (s.equals(")") && !last.equals("("))
                    return false;
                if (s.equals("}") && !last.equals("{"))
                    return false;
                if (s.equals("]") && !last.equals("["))
                    return false;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
