package br.csi.avaliadordeprojetos.service;

import br.csi.avaliadordeprojetos.model.aluno.Aluno;
import br.csi.avaliadordeprojetos.model.aluno.AlunoRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {this.repository = repository; }

    public void salvar(Aluno aluno){ this.repository.save(aluno);}

    public List<Aluno> listar(){

        return this.repository.findAll();
    }

    public Aluno getAluno(Long id)
    {
        return this.repository.findById(id).get();
    }
    public void excluir(Long id)
    {this.repository.deleteById(id);
    }

    public void atualizar(Aluno aluno)
    {
        Aluno a = this.repository.getReferenceById(aluno.getId());
        a.setNome(aluno.getNome());
        a.setEmail(aluno.getEmail());
        a.setMatricula(aluno.getMatricula());
        a.setEndereco(aluno.getEndereco());
        this.repository.save(a);
    }

    public void atualizarUUID(Aluno aluno) {

        Aluno a = this.repository.findAlunoByUuid(aluno.getUuid());

        if (a == null) {
            throw new RuntimeException("Aluno não encontrado com o UUID: " + aluno.getUuid());
        }

        a.setNome(aluno.getNome());
        a.setEmail(aluno.getEmail());
        a.setMatricula(aluno.getMatricula());
        a.setEndereco(aluno.getEndereco());

        this.repository.save(a);
    }
    public Aluno getAlunoUUID(String uuid)
    {
        UUID uuidformatado = UUID.fromString(uuid);
        return this.repository.findAlunoByUuid(uuidformatado);
    }
    public void deletarUUID(String uuid)
    {
        this.repository.deleteAlunoByUuid(UUID.fromString(uuid));
    }
}

