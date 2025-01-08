package br.com.fiap.techchallenge01.pedido.utils.mapper;

import br.com.fiap.techchallenge01.pedido.domain.Pedido;
import br.com.fiap.techchallenge01.pedido.domain.dto.response.PedidoResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoMapper {

    private final ModelMapper modelMapper;

    public PedidoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PedidoResponseDTO toResponse(Pedido pedido) {
        return modelMapper.map(pedido, PedidoResponseDTO.class);
    }

    public List<PedidoResponseDTO> toCollectionResponse(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}