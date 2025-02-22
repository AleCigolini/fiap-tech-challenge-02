package br.com.fiap.techchallenge02.produto;

import br.com.fiap.techchallenge02.produto.adapter.gateway.ProdutoGateway;
import br.com.fiap.techchallenge02.produto.application.usecase.ProdutoUseCaseImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoConfig {

    @Bean
    public ProdutoUseCaseImpl produtoUseCase(@Qualifier("produtoJpaGatewayImpl") ProdutoGateway produtoGateway) {
        return new ProdutoUseCaseImpl(produtoGateway);
    }
}
