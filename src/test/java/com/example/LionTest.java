package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LionTest {
    private final FelineBehavior feline = mock(FelineBehavior.class);

    @Test
    public void getKittensReturnsCountFromFeline() throws Exception {
        when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", feline);

        assertEquals(3, lion.getKittens());
        verify(feline).getKittens();
    }

    @Test
    public void getFoodReturnsFoodFromFeline() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(food);
        Lion lion = new Lion("Самка", feline);

        assertEquals(food, lion.getFood());
        verify(feline).eatMeat();
    }

    @Test
    public void getFoodPropagatesFelineException() throws Exception {
        Exception failure = new Exception("Ошибка получения пищи");
        when(feline.eatMeat()).thenThrow(failure);
        Lion lion = new Lion("Самец", feline);

        assertSame(failure, assertThrows(Exception.class, lion::getFood));
        verify(feline).eatMeat();
    }
}
