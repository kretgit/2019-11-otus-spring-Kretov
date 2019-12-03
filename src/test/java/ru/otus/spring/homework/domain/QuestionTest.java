package ru.otus.spring.homework.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тестируем класс Question")
public class QuestionTest {

    @DisplayName("Корректное создание объекта")
    @Test
    void shouldCanCreateObject() {
        Question question = new Question("вопрос", "вариант_ответа_1", "вариант_ответа_2","вариант_ответа_3", 3);

        assertEquals("вопрос",question.getQuestion());
        assertEquals(3, question.getAnswer());

    }

}
