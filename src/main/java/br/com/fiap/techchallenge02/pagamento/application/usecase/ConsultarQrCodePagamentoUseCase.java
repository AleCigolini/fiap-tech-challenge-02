package br.com.fiap.techchallenge02.pagamento.application.usecase;

import java.awt.image.BufferedImage;

public interface ConsultarQrCodePagamentoUseCase {

    BufferedImage gerarImagemCodigoQRCaixa();
}