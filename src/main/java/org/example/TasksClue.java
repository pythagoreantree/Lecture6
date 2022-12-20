package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class TasksClue {

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
        if (inputString == null || inputString.isEmpty())
            return inputString;

        int counter = 1;
        char firstCharacter = inputString.charAt(0);
        int len = inputString.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < len; i++) {
            char currentCharacter = inputString.charAt(i);
            if (currentCharacter != firstCharacter) {
                sb.append(String.valueOf(firstCharacter) + counter);
                counter = 0;
                firstCharacter = currentCharacter;
            }
            counter++;
        }
        if (counter != 0) {
            sb.append(String.valueOf(firstCharacter) + counter);
        }

        return sb.toString();
    }


    /*
     * Count frequencies in an array {1, 2, 1, 1, 3, 2, 1, 4, 2, 2, 3, 4}
     *
     * */
    public static void countFrequencies(int[] nums) {

    }

    public static boolean isValidSequence(String[] parentheses) {

        Deque<String> stack = new ArrayDeque<>();
        for (String bracket: parentheses) {
            if (bracket.equals("(")) {
                stack.push("(");
            } else if (bracket.equals(")")) {
                String inStack = stack.pop();
                if (!inStack.equals("(")) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
