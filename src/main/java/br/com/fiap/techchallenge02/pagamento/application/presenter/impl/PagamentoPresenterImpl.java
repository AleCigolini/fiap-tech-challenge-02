package br.com.fiap.techchallenge02.pagamento.application.presenter.impl;

import br.com.fiap.techchallenge02.pagamento.application.presenter.PagamentoPresenter;
import br.com.fiap.techchallenge02.pagamento.common.domain.dto.response.PagamentoResponseDto;
import br.com.fiap.techchallenge02.pagamento.domain.Pagamento;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PagamentoPresenterImpl implements PagamentoPresenter {

    private final ModelMapper modelMapper;

    @Override
    public List<PagamentoResponseDto> pagamentosParaPagamentoResponseDTOs(List<Pagamento> pagamentos) {
        return pagamentos.stream().map(pedido -> modelMapper.map(pedido, PagamentoResponseDto.class)).toList();
    }
}