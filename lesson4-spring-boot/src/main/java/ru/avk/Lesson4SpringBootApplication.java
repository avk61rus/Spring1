package ru.avk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson4SpringBootApplication {

    public static void main(String[] args) {
        System.out.println("Запуск сработал");
        SpringApplication.run(Lesson4SpringBootApplication.class, args);
    }
}