package ru.otus.spring.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.homework.service.QuestionService;

/**
 * Автор: Кретов АА, 02.12.2019
 * Консольная программа для проведения тестирования.
 * без использования XML-конфигурации
 * с добавлением локализации
 */

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        QuestionService service = context.getBean(QuestionService.class);
        service.askQuestions();
    }

}
