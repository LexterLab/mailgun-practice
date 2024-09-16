package com.test.testmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TestmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestmailApplication.class, args);
    }

}
