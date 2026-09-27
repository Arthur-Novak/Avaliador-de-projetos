package br.csi.avaliadordeprojetos.model.projeto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>
{
    public Projeto findProjetoByUuid(UUID uuid);
    public void deleteProjetoByUuid(UUID uuid);
}