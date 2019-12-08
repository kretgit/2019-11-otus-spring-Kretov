package ru.otus.spring.homework.dao;

import ru.otus.spring.homework.domain.Question;

import java.util.Map;

public interface QuestionDao {

    Map<Question, Integer> getQuestions(int localeNumber);
}
