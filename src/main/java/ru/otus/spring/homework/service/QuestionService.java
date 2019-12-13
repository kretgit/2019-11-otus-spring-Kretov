package ru.otus.spring.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.otus.spring.homework.dao.QuestionDao;
import ru.otus.spring.homework.domain.Dialog;
import ru.otus.spring.homework.domain.Question;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

@Component
public class QuestionService {

    private final QuestionDao dao;

    private final MessageSource messageSource;

    @Autowired
    public QuestionService(QuestionDao dao, MessageSource messageSource) {
        this.dao = dao;
        this.messageSource = messageSource;
    }


    private Dialog getLocaleText(int localeNumber) {
        switch (localeNumber) {
            case 1:
                return new Dialog(messageSource.getMessage("greeting", new String[]{}, new Locale("ru", "RU")),
                        messageSource.getMessage("choosing", new String[]{}, new Locale("ru", "RU")),
                        messageSource.getMessage("variant", new String[]{}, new Locale("ru", "RU")),
                        messageSource.getMessage("answer.true", new String[]{}, new Locale("ru", "RU")),
                        messageSource.getMessage("answer.false", new String[]{}, new Locale("ru", "RU")),
                        messageSource.getMessage("answer.pass", new String[]{}, new Locale("ru", "RU")));
            case 2:
                return new Dialog(messageSource.getMessage("greeting", new String[]{}, Locale.US),
                        messageSource.getMessage("choosing", new String[]{}, Locale.US),
                        messageSource.getMessage("variant", new String[]{}, Locale.US),
                        messageSource.getMessage("answer.true", new String[]{}, Locale.US),
                        messageSource.getMessage("answer.false", new String[]{}, Locale.US),
                        messageSource.getMessage("answer.pass", new String[]{}, Locale.US));
        }
        return null;
    }


    public void askQuestions() {

        System.out.println("Выберите предпочтаемый язык / What language do you prefer");
        System.out.println("Нажмите \"1\" для Русского / Press \"2\" for English");
        Scanner localeScanner = new Scanner(System.in);
        int localeNumber = localeScanner.nextInt();

        Dialog dialog = getLocaleText(localeNumber);

        System.out.println(dialog.getGreeting());
        Scanner fioScanner = new Scanner(System.in);
        String fio = fioScanner.nextLine();

        System.out.println("\n\n" + fio + ", " + dialog.getChoosing());
        Map<Question, Integer> questionMap = dao.getQuestions(localeNumber);

        int rightAnwerCounter = 0;

        for (Map.Entry<Question, Integer> entry : questionMap.entrySet()) {
            Question question = entry.getKey();
            System.out.println("\n\n" + question.getQuestion() + ":");
            System.out.println("1 -- " + question.getVariant_1());
            System.out.println("2 -- " + question.getVariant_2());
            System.out.println("3 -- " + question.getVariant_3());
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            System.out.println(dialog.getVariant() + number);

            if (number == entry.getValue()) {
                System.out.println(dialog.getTrueAnswer());
                rightAnwerCounter++;
            } else {
                System.out.println(dialog.getFalseAnswer());
            }

        }

        System.out.println("\n\n" + dialog.getPassAnswer() + rightAnwerCounter);


    }


}
