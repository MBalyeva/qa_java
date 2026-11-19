package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class AnimalInvalidFoodParameterizedTest {
    private final String kind;

    public AnimalInvalidFoodParameterizedTest(String kind) {
        this.kind = kind;
    }

    @Parameterized.Parameters(name = "invalid kind = {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {{""}, {"Всеядное"}, {null}});
    }

    @Test
    public void getFoodRejectsUnknownKind() {
        Exception exception = assertThrows(Exception.class, () -> new Animal().getFood(kind));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }
}
