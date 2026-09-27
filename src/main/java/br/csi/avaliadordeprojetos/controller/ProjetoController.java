package br.csi.avaliadordeprojetos.controller;

import br.csi.avaliadordeprojetos.model.projeto.Projeto;
import br.csi.avaliadordeprojetos.service.ProjetoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projeto")
@Tag(name = "Projetos", description = "Operações relacionadas aos projetos")
public class ProjetoController {

    private ProjetoService projetoservice;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoservice = projetoService;
    }

    @Operation(
            summary = "Listar projetos",
            description = "Lista todos os projetos cadastrados."
    )
    @GetMapping("/listar")
    public List<Projeto> listar()
    {
        return this.projetoservice.listar();
    }


    @Operation(
            summary = "Buscar projeto por ID",
            description = "Busca um projeto através do seu ID."
    )
    @GetMapping("/{id}")
    public Projeto projeto(
            @Parameter(
                    description = "ID do projeto",
                    example = "1"
            )
            @PathVariable Long id)
    {
        return this.projetoservice.getProjeto(id);
    }


    @Operation(
            summary = "Cadastrar projeto",
            description = "Cadastra um novo projeto."
    )
    @PostMapping()
    public void salvar(@RequestBody Projeto projeto)
    {
        this.projetoservice.salvar(projeto);
    }


    @Operation(
            summary = "Atualizar projeto",
            description = "Atualiza os dados de um projeto."
    )
    @PutMapping
    public void atualizar(@RequestBody Projeto projeto)
    {
        this.projetoservice.atualizar(projeto);
    }


    @Operation(
            summary = "Excluir projeto",
            description = "Exclui um projeto através do seu ID."
    )
    @DeleteMapping("/{id}")
    public void deletar(
            @Parameter(
                    description = "ID do projeto",
                    example = "1"
            )
            @PathVariable Long id)
    {
        this.projetoservice.excluir(id);
    }


    @Operation(
            summary = "Buscar projeto por UUID",
            description = "Busca um projeto através do seu UUID."
    )
    @GetMapping("/uuid/{uuid}")
    public Projeto projetoUUID(
            @Parameter(
                    description = "UUID do projeto",
                    example = "550e8400-e29b-41d4-a716-446655440000"
            )
            @PathVariable String uuid)
    {
        return this.projetoservice.getProjetoUUID(uuid);
    }


    @Operation(
            summary = "Atualizar projeto por UUID",
            description = "Atualiza os dados de um projeto através do seu UUID."
    )
    @PutMapping("/uuid")
    public void atualizarUUID(@RequestBody Projeto projeto)
    {
        this.projetoservice.atualizarUUID(projeto);
    }

}