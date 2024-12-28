package br.com.fiap.techchallenge01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Techchallenge01Application {

    public static void main(String[] args) {
        SpringApplication.run(Techchallenge01Application.class, args);
    }


}
