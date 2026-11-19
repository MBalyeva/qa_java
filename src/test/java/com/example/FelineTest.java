package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class FelineTest {
    private final Feline feline = new Feline();

    @Test
    public void eatMeatReturnsFoodForPredators() throws Exception {
        Feline felineSpy = spy(feline);

        assertEquals(List.of("Животные", "Птицы", "Рыба"), felineSpy.eatMeat());
        verify(felineSpy).getFood("Хищник");
    }

    @Test
    public void getFamilyReturnsFelineFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutArgumentsReturnsOneKitten() {
        assertEquals(1, feline.getKittens());
    }
}
