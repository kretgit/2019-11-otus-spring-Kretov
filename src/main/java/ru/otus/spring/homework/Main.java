package ru.otus.spring.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Автор: Кретов АА, 22.12.2019
 * Консольная программа для проведения тестирования.
 * с добавлением локализации
 * переписанная на spring-boot
 * с добавлением spring-shell (для начала тестирования ввести команду 'start')
 * с отключением spring-shell при тестировании
 */

@SpringBootApplication
public class Main {


    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

}
