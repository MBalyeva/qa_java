package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CatTest {

    private final Feline feline = mock(Feline.class);
    private final Cat cat = new Cat(feline);

    @Test
    public void getSoundReturnsMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnsFoodFromFeline() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(food);

        assertEquals(food, cat.getFood());
    }

    @Test
    public void getFoodThrowsWhenFoodUnavailable() throws Exception {
        when(feline.eatMeat()).thenThrow(new Exception("Ошибка получения пищи"));

        assertThrows(Exception.class, cat::getFood);
    }
}

