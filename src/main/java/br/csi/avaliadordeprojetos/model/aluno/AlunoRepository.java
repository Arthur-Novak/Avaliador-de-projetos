package br.csi.avaliadordeprojetos.model.aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AlunoRepository extends JpaRepository<Aluno, Long>
{
    public Aluno findAlunoByUuid(UUID uuid);
    public void deleteAlunoByUuid(UUID uuid);

    @Query(value = "SELECT a.id as id, a.nome as nome, a.matricula as matricula, a.email as email" + "FROM alunos a where a.idprojeto =:id", nativeQuery = true)
    List<Aluno.AlunoDTO> findAlunosByProjeto(@Param("id")int id);
}
