package br.com.fiap.techchallenge02.pagamento.application.controller;

import br.com.fiap.techchallenge02.pagamento.common.domain.dto.response.PagamentoResponseDto;

import java.awt.image.BufferedImage;
import java.util.List;

public interface PagamentoController {

    List<PagamentoResponseDto> buscarPagamentosPorPedidoId(String pedidoId);

    BufferedImage gerarImagemCodigoQRCaixa();
}