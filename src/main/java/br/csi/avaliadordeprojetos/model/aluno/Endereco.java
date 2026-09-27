package br.csi.avaliadordeprojetos.model.aluno;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Endereço do aluno")

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Endereco
{
    @Schema(description = "Complemento do endereço", example = "Apto 101")
    private String complemento;

    @NotBlank
    @Schema(description = "Bairro", example = "Centro")
    private String bairro;

    @Size(min = 8, max = 9, message = "Cep invalido")
    @Schema(description = "CEP", example = "97050000")
    private String cep;

    @Schema(description = "Número da residência", example = "123")
    @NotBlank
    private String numero;

    @Schema(description = "Cidade", example = "Santa Maria")
    @NotBlank
    private String cidade;

    @Schema(description = "Estado", example = "RS")
    @NotBlank
    @Size(max = 2)
    private String uf;


    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}
