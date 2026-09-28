package br.csi.avaliadordeprojetos.model.projeto;

import br.csi.avaliadordeprojetos.model.aluno.Aluno;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Schema(description = "Entidade que representa um projeto")
@Entity
@Table(name = "projetos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador do projeto", example = "1")
    private long id;

    @UuidGenerator
    @Schema(description = "Identificador único do projeto")
    private UUID uuid;

    @NonNull
    @Schema(description = "Nome do projeto", example = "Sistema de Avaliação")
    private String nome;

    @NonNull
    @Schema(description = "Descrição do projeto", example = "Sistema para avaliação de projetos acadêmicos")
    private String descricao;

    private int ano;
    private int semestre;

    @OneToMany(mappedBy = "projeto")
    @JsonIgnore
    private List<Aluno> alunos;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}