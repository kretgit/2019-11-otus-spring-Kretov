package ru.otus.spring.homework.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.homework.service.QuestionService;

@ShellComponent
public class ApplicationCommands {

    private final QuestionService service;

    @Autowired
    public ApplicationCommands(QuestionService service) {
        this.service = service;
    }

    @ShellMethod(value = "initial command", key = "start")
    public void startTesting() {

        service.askQuestions();

    }
}
