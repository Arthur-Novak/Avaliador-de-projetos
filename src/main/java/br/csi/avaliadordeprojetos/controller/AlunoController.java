package br.csi.avaliadordeprojetos.controller;

import br.csi.avaliadordeprojetos.model.aluno.Aluno;
import br.csi.avaliadordeprojetos.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;
import java.util.UUID;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/aluno")
@Tag(name = "Alunos", description = "Operações relacionadas aos alunos")
public class AlunoController {
    private AlunoService alunoservice;
    public AlunoController(AlunoService alunoService) {this.alunoservice = alunoService;}

    /*testar:
    * http://localhost:8080/avaliador-de-projetos/aluno/listar */
    @Operation(
            summary = "Listar alunos",
            description = "Lista todos os alunos cadastrados."
    )
    @GetMapping("/listar")
    public List<Aluno> listar()
    {
        return this.alunoservice.listar();
    }
    /*testar:
     * http://localhost:8080/avaliador-de-projetos/aluno/listar/1 */
    @Operation(
            summary = "Buscar aluno por ID",
            description = "Busca um aluno utilizando seu ID."
    )
    @GetMapping("/{id}")
    public Aluno aluno( @Parameter(description = "ID do aluno", example = "1")@PathVariable Long id)
    {
        return this.alunoservice.getAluno(id);
    }

    /*exemplo de uso para @RequestBody e POST
    * http://localhost:8080/avaliador-de-projetos/aluno/print-json */
    @Operation(
            summary = "Imprimir JSON",
            description = "Recebe um JSON e imprime seu conteúdo no console."
    )
    @PostMapping("/print-json")
    public void printJSon(@RequestBody String json)
    {
        System.out.println(json);
    }

    /*http://localhost:8080/avaliador-de-projetos/aluno */
    @Operation(
            summary = "Cadastrar aluno",
            description = "Cadastra um novo aluno."
    )
    @PostMapping()
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid Aluno aluno, UriComponentsBuilder uriBuilder)
    {
        this.alunoservice.salvar(aluno);
        //monta a uri da aplicação dinamicamente
        URI uri = uriBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri();
        // o created(uri) ira colocar no cabeçalho da requisiçao da rasposta
        //o parametro location com a uri de acesso ao recurso criado
        return ResponseEntity.created(uri).body(aluno);
    }

    /*http://localhost:8080/avaliador-de-projetos/aluno */
    @Operation(
            summary = "Atualizar aluno",
            description = "Atualiza os dados de um aluno."
    )
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Aluno aluno)
    {
        this.alunoservice.atualizar((aluno));
        return ResponseEntity.ok(aluno);
    }


    /*http://localhost:8080/avaliador-de-projetos/aluno/1 */
    @Operation(
            summary = "Excluir aluno",
            description = "Exclui um aluno utilizando seu ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@Parameter(description = "ID do aluno", example = "1") @PathVariable Long id)
    {
        this.alunoservice.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Buscar aluno por UUID",
            description = "Busca um aluno utilizando seu UUID."
    )
    @GetMapping("/uuid/{uuid}")
    public Aluno aluno(@Parameter(
            description = "UUID do aluno",
            example = "550e8400-e29b-41d4-a716-446655440000"
    ) @PathVariable String uuid)
    {
        return this.alunoservice.getAlunoUUID(uuid);
    }

    @Operation(
            summary = "Atualizar aluno por UUID",
            description = "Atualiza os dados de um aluno utilizando seu UUID."
    )
    @PutMapping("/uuid")
    public void atualizarUUID(@RequestBody Aluno aluno)
    {
        this.alunoservice.atualizarUUID(aluno);
    }

}
