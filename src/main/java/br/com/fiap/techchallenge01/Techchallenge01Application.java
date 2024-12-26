package br.com.fiap.techchallenge01;

import br.com.fiap.techchallenge01.identificacao.application.service.AcompanhamentoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Techchallenge01Application {

    private static AcompanhamentoService acompanhamentoService;

    @Autowired
    public void setAcompanhamentoService(AcompanhamentoService acompanhamentoService) {
        Techchallenge01Application.acompanhamentoService = acompanhamentoService;
    }

    @PostConstruct
    public void init() {
        try {
            System.out.println(acompanhamentoService.buscarAcompanhamentoPorId(1L).getNome());
            System.out.println(acompanhamentoService.buscarAcompanhamentoPorId(10L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(Techchallenge01Application.class, args);
    }


}
