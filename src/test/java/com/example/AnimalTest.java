package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    @Test
    public void getFamilyReturnsDescriptionOfAnimalFamilies() {
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                new Animal().getFamily());
    }
}
