package br.com.fiap.techchallenge01.identificacao.utils.mapper;

import br.com.fiap.techchallenge01.identificacao.domain.Acompanhamento;
import br.com.fiap.techchallenge01.identificacao.domain.dto.response.AcompanhamentoResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AcompanhamentoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public AcompanhamentoResponseDTO toResponse(Acompanhamento acompanhamento) {
        return modelMapper.map(acompanhamento, AcompanhamentoResponseDTO.class);
    }

    public List<AcompanhamentoResponseDTO> toCollectionResponse(List<Acompanhamento> acompanhamentos) {
        return acompanhamentos.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

}
