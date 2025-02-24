package br.com.fiap.techchallenge02.produto;

import br.com.fiap.techchallenge02.produto.adapter.gateway.CategoriaProdutoGateway;
import br.com.fiap.techchallenge02.produto.application.usecase.CategoriaProdutoUseCaseImpl;
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
