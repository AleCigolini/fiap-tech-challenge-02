package br.com.fiap.techchallenge02.pagamento.infrastructure.client.mercadopago.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MercadoPagoSignatureValidator {

    @Value("${client.mercado-pago.auth_signature}")
    private String signature;

    public boolean isValid(String signature) {
        return this.signature.equals(signature);
    }
}