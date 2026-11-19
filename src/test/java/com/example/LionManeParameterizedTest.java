package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class LionManeParameterizedTest {
    private final String sex;
    private final boolean expectedMane;

    public LionManeParameterizedTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Parameterized.Parameters(name = "sex = {0}, mane = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {{"Самец", true}, {"Самка", false}});
    }

    @Test
    public void doesHaveManeMatchesSex() throws Exception {
        Lion lion = new Lion(sex, mock(FelineBehavior.class));
        assertEquals(expectedMane, lion.doesHaveMane());
    }
}
