package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class LionInvalidSexParameterizedTest {
    private final String sex;

    public LionInvalidSexParameterizedTest(String sex) {
        this.sex = sex;
    }

    @Parameterized.Parameters(name = "invalid sex = {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {{""}, {"самец"}, {"Неизвестно"}, {null}});
    }

    @Test
    public void constructorRejectsInvalidSex() {
        Exception exception = assertThrows(Exception.class,
                () -> new Lion(sex, mock(FelineBehavior.class)));

        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }
}
