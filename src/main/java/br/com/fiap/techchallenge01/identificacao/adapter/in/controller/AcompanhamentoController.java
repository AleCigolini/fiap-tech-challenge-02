package br.com.fiap.techchallenge01.identificacao.adapter.in.controller;

import br.com.fiap.techchallenge01.identificacao.adapter.in.controller.api.AcompanhamentoApi;
import br.com.fiap.techchallenge01.identificacao.application.service.AcompanhamentoService;
import br.com.fiap.techchallenge01.identificacao.domain.dto.request.AcompanhamentoRequestDTO;
import br.com.fiap.techchallenge01.identificacao.domain.dto.response.AcompanhamentoResponseDTO;
import br.com.fiap.techchallenge01.identificacao.utils.mapper.AcompanhamentoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acompanhamentos")
public class AcompanhamentoController implements AcompanhamentoApi {

    @Autowired
    private AcompanhamentoMapper acompanhamentoMapper;

    @Autowired
    private AcompanhamentoService acompanhamentoService;

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<AcompanhamentoResponseDTO> buscarAcompanhamento(@PathVariable Long id) {
        return new ResponseEntity<>(acompanhamentoMapper.toResponse(acompanhamentoService.buscarAcompanhamentoPorId(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AcompanhamentoRequestDTO> cadastrarAcompanhamento(AcompanhamentoRequestDTO acompanhamentoRequestDto) {
        return null;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<AcompanhamentoResponseDTO>> listarAcompanhamentos() {
        return new ResponseEntity<>(acompanhamentoMapper.toCollectionResponse(acompanhamentoService.buscarAcompanhamentos()), HttpStatus.OK);
    }
}
