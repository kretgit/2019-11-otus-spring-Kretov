package ru.otus.spring.homework.service;

import ru.otus.spring.homework.dao.QuestionDao;
import ru.otus.spring.homework.domain.Question;

import java.util.Map;
import java.util.Scanner;

public class QuestionService {

    private QuestionDao dao;

    public QuestionService(QuestionDao dao) {
        this.dao = dao;
    }


    public void askQuestions() {

        System.out.println("Введите ваше ФИО в консоли");
        Scanner fioScanner = new Scanner(System.in);
        String fio = fioScanner.nextLine();

        System.out.println("\n\n" + fio + ", выберите верный вариант ответа...");
        Map<Question, Integer> questionMap = dao.getQuestions();

        int rightAnwerCounter = 0;

        for (Map.Entry<Question, Integer> entry : questionMap.entrySet()) {
            Question question = entry.getKey();
            System.out.println("\n\n" + question.getQuestion() + ":");
            System.out.println("1 -- " + question.getVariant_1());
            System.out.println("2 -- " + question.getVariant_2());
            System.out.println("3 -- " + question.getVariant_3());
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            System.out.println("Вы выбрали вариант " + number);

            if (number == entry.getValue()) {
                System.out.println("Это правильный ответ.");
                rightAnwerCounter++;
            } else {
                System.out.println("Ваш ответ неверный.");
            }

        }

        System.out.println("\n\nВСЕГО ПРАВИЛЬНЫХ ОТВЕТОВ: " + rightAnwerCounter);


    }


}
