package br.com.fiap.techchallenge02.produto_old;

import br.com.fiap.techchallenge02.produto_old.adapter.gateway.CategoriaProdutoGateway;
import br.com.fiap.techchallenge02.produto_old.application.usecase.CategoriaProdutoUseCaseImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoriaProdutoConfig {

    @Bean
    public CategoriaProdutoUseCaseImpl categoriaProdutoUseCase(@Qualifier("categoriaProdutoJpaGatewayImpl") CategoriaProdutoGateway categoriaProdutoGateway) {
        return new CategoriaProdutoUseCaseImpl(categoriaProdutoGateway);
    }
}
