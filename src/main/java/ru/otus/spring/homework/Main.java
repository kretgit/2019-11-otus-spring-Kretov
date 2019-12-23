package ru.otus.spring.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.spring.homework.service.QuestionService;

/**
 * Автор: Кретов АА, 22.12.2019
 * Консольная программа для проведения тестирования.
 * с добавлением локализации
 * переписанная на spring-boot
 */

@SpringBootApplication
public class Main {


    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Main.class, args);

        QuestionService service = context.getBean(QuestionService.class);
        service.askQuestions();
    }

}
