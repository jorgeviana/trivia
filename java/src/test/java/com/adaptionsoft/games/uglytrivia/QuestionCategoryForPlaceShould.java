package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(Parameterized.class)
public class QuestionCategoryForPlaceShould {
    private int currentPlace;
    private String category;

    public QuestionCategoryForPlaceShould(int currentPlace, String category){
        this.currentPlace = currentPlace;
        this.category = category;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0, "Pop"},
                {1, "Science"},
                {2, "Sports"},
                {3, "Rock"},
                {4, "Pop"},
                {5, "Science"},
                {6, "Sports"},
                {7, "Rock"},
                {8, "Pop"},
                {9, "Science"},
                {10, "Sports"},
                {11, "Rock"},
        });
    }

    @Test
    public void get_category_for_place() {
        Questions questions = new Questions();

        assertEquals(category, questions.getCategoryForPlace(currentPlace));
    }
}