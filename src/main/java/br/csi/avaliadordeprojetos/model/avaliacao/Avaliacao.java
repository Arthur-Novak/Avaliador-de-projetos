package br.csi.avaliadordeprojetos.model.avaliacao;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Schema(description = "Entidade que representa uma avaliação")
@Entity
@Table(name = "avaliacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador da avaliação", example = "1")
    private long id;

    @UuidGenerator
    @Schema(description = "Identificador único da avaliação")
    private UUID uuid;

    @NonNull
    @Schema(description = "Nota da avaliação", example = "9.5")
    private double nota;

    @NonNull
    @Schema(description = "Comentário da avaliação", example = "Projeto muito bem desenvolvido.")
    private String comentario;


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

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}