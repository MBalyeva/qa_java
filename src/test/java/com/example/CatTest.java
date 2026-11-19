package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CatTest {
    private final Predator predator = mock(Predator.class);
    private final Cat cat = new Cat(predator);

    @Test
    public void getSoundReturnsMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnsFoodFromPredator() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(predator.eatMeat()).thenReturn(food);

        assertEquals(food, cat.getFood());
        verify(predator).eatMeat();
    }

    @Test
    public void getFoodPropagatesPredatorException() throws Exception {
        Exception failure = new Exception("Ошибка получения пищи");
        when(predator.eatMeat()).thenThrow(failure);

        assertSame(failure, assertThrows(Exception.class, cat::getFood));
        verify(predator).eatMeat();
    }
}
