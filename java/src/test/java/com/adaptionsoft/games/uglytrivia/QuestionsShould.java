package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class QuestionsShould {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Pop"}, {"Rock"}, {"Science"}, {"Sports"}
        });
    }

    private String questionCategory;

    public QuestionsShould(String questionCategory) {
        this.questionCategory = questionCategory;
    }

    @Test
    public void questions_for_categories() {
        Questions questions = new Questions();

        questions.fillQuestions();

        assertFalse(questions.askQuestionForCategory(questionCategory).isEmpty());
    }
}