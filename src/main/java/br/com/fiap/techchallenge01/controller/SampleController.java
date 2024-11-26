package br.com.fiap.techchallenge01.controller;

import br.com.fiap.techchallenge01.model.dto.SampleDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/samples")
public class SampleController {

    @Operation(summary = "Buscar todos os exemplos")
    @GetMapping("")
    public ResponseEntity<String> getSamples() {
        return ResponseEntity.ok().body("Lorem ipsum dolor sit amet");
    }

    @Operation(summary = "Adicionar um exemplo")
    @PostMapping("")
    public ResponseEntity<String> addSample(@RequestBody @Valid SampleDto sampleDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/sample/id")).body(sampleDto.description());
    }

    @Operation(summary = "Atualizar um exemplo")
    @PostMapping("/{id}")
    public ResponseEntity<String> updateSample(@PathVariable Long id, @RequestBody @Valid SampleDto sampleDto) {
        return ResponseEntity.ok().body(sampleDto.description() + " - " + id);
    }

    @Operation(summary = "Deletar um exemplo")
    @DeleteMapping("/{id}")
    public String deleteSample(@PathVariable Long id) {
        return String.valueOf(id);
    }
}
