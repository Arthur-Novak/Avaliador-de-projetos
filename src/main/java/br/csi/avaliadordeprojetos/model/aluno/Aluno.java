package br.csi.avaliadordeprojetos.model.aluno;

import br.csi.avaliadordeprojetos.model.projeto.Projeto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;
@Schema(description = "Entidade que representa um aluno")
@Entity
@Table(name = "alunos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Aluno {

    @Schema(description = "Identificador do aluno")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank

    @Schema(description = "Identificador único do aluno")
    @UuidGenerator
    private UUID uuid;

    @Schema(description = "Nome completo do aluno", example = "João da Silva")
    @NonNull
    private String nome;

    @Schema(description = "Matrícula do aluno", example = "202500123")
    @Size(max = 8, message = "Matricula deve ter no máximo 8 digitos")
    private String matricula;

    @Schema(description = "E-mail do aluno", example = "joao@email.com")
    @Email(message = "Email invalido")
    private String email;
    @Schema(description = "Endereço do aluno")
    @Embedded
    @NonNull
    private Endereco endereco;


    @ManyToOne
    @JoinColumn(name = "idprojeto")
    private Projeto projeto;

    public interface AlunoDTO
    {
        Long getId();
        String getNome();
        String getMatricula();
        String getEmail();

    }



   /* public Aluno(String nome, String email, String matricula, Endereco endereco)
    {
        this.nome= nome;
        this.email = email;
        this.endereco = endereco;
        this.matricula = matricula;
    }*/


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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
