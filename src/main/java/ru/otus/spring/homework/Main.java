package ru.otus.spring.homework;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.homework.service.QuestionService;

/**Автор: Кретов АА, 02.12.2019
 * Консольная программа для проведения тестирования.
 */

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        QuestionService service = context.getBean(QuestionService.class);
        service.askQuestions();
    }

}
