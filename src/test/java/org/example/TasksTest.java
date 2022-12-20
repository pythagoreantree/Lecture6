package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TasksTest {

    @Test
    void encode() {
        String input = "aabbbc";
        String result = Tasks.encode(input);
        Assertions.assertEquals("a2b3c1", result);
    }

    @Test
    void isValidSequence() {
        String[] sequence = {"(", ")", "(", "(", "(", "(", ")", ")", ")"};
        boolean isValid = Tasks.isValidSequence(sequence);
        System.out.println(isValid);
    }
}