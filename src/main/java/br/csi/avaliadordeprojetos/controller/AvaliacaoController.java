package br.csi.avaliadordeprojetos.controller;

import br.csi.avaliadordeprojetos.model.avaliacao.Avaliacao;
import br.csi.avaliadordeprojetos.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacao")
@Tag(name = "Avaliações", description = "Operações relacionadas às avaliações")
public class AvaliacaoController {

    private AvaliacaoService avaliacaoservice;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoservice = avaliacaoService;
    }


    @Operation(
            summary = "Listar avaliações",
            description = "Lista todas as avaliações cadastradas."
    )
    @GetMapping("/listar")
    public List<Avaliacao> listar()
    {
        return this.avaliacaoservice.listar();
    }


    @Operation(
            summary = "Buscar avaliação por ID",
            description = "Busca uma avaliação através do seu ID."
    )
    @GetMapping("/{id}")
    public Avaliacao avaliacao(
            @Parameter(
                    description = "ID da avaliação",
                    example = "1"
            )
            @PathVariable Long id)
    {
        return this.avaliacaoservice.getAvaliacao(id);
    }


    @Operation(
            summary = "Cadastrar avaliação",
            description = "Cadastra uma nova avaliação."
    )
    @PostMapping()
    public void salvar(@RequestBody Avaliacao avaliacao)
    {
        this.avaliacaoservice.salvar(avaliacao);
    }


    @Operation(
            summary = "Atualizar avaliação",
            description = "Atualiza os dados de uma avaliação."
    )
    @PutMapping
    public void atualizar(@RequestBody Avaliacao avaliacao)
    {
        this.avaliacaoservice.atualizar(avaliacao);
    }


    @Operation(
            summary = "Excluir avaliação",
            description = "Exclui uma avaliação através do seu ID."
    )
    @DeleteMapping("/{id}")
    public void deletar(
            @Parameter(
                    description = "ID da avaliação",
                    example = "1"
            )
            @PathVariable Long id)
    {
        this.avaliacaoservice.excluir(id);
    }


    @Operation(
            summary = "Buscar avaliação por UUID",
            description = "Busca uma avaliação através do seu UUID."
    )
    @GetMapping("/uuid/{uuid}")
    public Avaliacao avaliacaoUUID(
            @Parameter(
                    description = "UUID da avaliação",
                    example = "550e8400-e29b-41d4-a716-446655440000"
            )
            @PathVariable String uuid)
    {
        return this.avaliacaoservice.getAvaliacaoUUID(uuid);
    }


    @Operation(
            summary = "Atualizar avaliação por UUID",
            description = "Atualiza os dados de uma avaliação através do seu UUID."
    )
    @PutMapping("/uuid")
    public void atualizarUUID(@RequestBody Avaliacao avaliacao)
    {
        this.avaliacaoservice.atualizarUUID(avaliacao);
    }

}