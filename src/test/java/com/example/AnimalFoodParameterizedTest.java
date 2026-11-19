package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalFoodParameterizedTest {
    private final String kind;
    private final List<String> food;

    public AnimalFoodParameterizedTest(String kind, List<String> food) {
        this.kind = kind;
        this.food = food;
    }

    @Parameterized.Parameters(name = "kind = {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        });
    }

    @Test
    public void getFoodReturnsFoodForAnimalKind() throws Exception {
        assertEquals(food, new Animal().getFood(kind));
    }
}
