package br.com.fiap.techchallenge02.pedido;

import br.com.fiap.techchallenge02.pedido.adapter.gateway.PedidoGateway;
import br.com.fiap.techchallenge02.pedido.application.usecase.PedidoUseCaseImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoConfig {

    @Bean
    public PedidoUseCaseImpl pedidoUseCase(@Qualifier("pedidoJpaGatewayImpl") PedidoGateway pedidoGateway) {
        return new PedidoUseCaseImpl(pedidoGateway);
    }


}

