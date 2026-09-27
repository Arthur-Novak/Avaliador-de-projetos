package br.csi.avaliadordeprojetos.model.avaliacao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>
{
    public Avaliacao findAvaliacaoByUuid(UUID uuid);
    public void deleteAvaliacaoByUuid(UUID uuid);
}