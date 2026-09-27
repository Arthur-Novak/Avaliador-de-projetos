package br.csi.avaliadordeprojetos.service;

import br.csi.avaliadordeprojetos.model.projeto.Projeto;
import br.csi.avaliadordeprojetos.model.projeto.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjetoService {

    private final ProjetoRepository repository;

    public ProjetoService(ProjetoRepository repository) {
        this.repository = repository;
    }

    public void salvar(Projeto projeto) {
        this.repository.save(projeto);
    }

    public List<Projeto> listar() {

        return this.repository.findAll();
    }

    public Projeto getProjeto(Long id)
    {
        return this.repository.findById(id).get();
    }

    public void excluir(Long id)
    {
        this.repository.deleteById(id);
    }

    public void atualizar(Projeto projeto)
    {
        Projeto p = this.repository.getReferenceById(projeto.getId());

        p.setNome(projeto.getNome());
        p.setDescricao(projeto.getDescricao());

        this.repository.save(p);
    }

    public void atualizarUUID(Projeto projeto)
    {
        Projeto p = this.repository.findProjetoByUuid(projeto.getUuid());

        if (p == null) {
            throw new RuntimeException(
                    "Projeto não encontrado com o UUID: " + projeto.getUuid()
            );
        }

        p.setNome(projeto.getNome());
        p.setDescricao(projeto.getDescricao());

        this.repository.save(p);
    }

    public Projeto getProjetoUUID(String uuid)
    {
        UUID uuidformatado = UUID.fromString(uuid);

        return this.repository.findProjetoByUuid(uuidformatado);
    }

    public void deletarUUID(String uuid)
    {
        this.repository.deleteProjetoByUuid(UUID.fromString(uuid));
    }
}