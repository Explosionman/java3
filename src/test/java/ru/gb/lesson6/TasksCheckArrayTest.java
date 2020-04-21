package ru.gb.lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TasksCheckArrayTest {
    private int[] actual;
    private boolean expected;

    public TasksCheckArrayTest(int[] actual, boolean expected) {
        this.actual = actual;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection testCasesForGetModifiedArray() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 4, 1, 4}, true},
                {new int[]{1, 1, 1, 4, 3}, false},
                {new int[]{1, 1, 1, 1, 1}, false},
                {new int[]{4, 4, 4, 4, 4}, false}
        });
    }

    Tasks task;

    @Before
    public void init() {
        task = new Tasks();
    }

    @Test
    public void massTestGetArrayAfterLastDigitFour() {
        boolean result = task.checkArray(actual);
        Assert.assertEquals(expected, result);
    }
}
