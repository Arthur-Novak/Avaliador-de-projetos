package br.csi.avaliadordeprojetos.service;

import br.csi.avaliadordeprojetos.model.avaliacao.Avaliacao;
import br.csi.avaliadordeprojetos.model.avaliacao.AvaliacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository repository;

    public AvaliacaoService(AvaliacaoRepository repository) {
        this.repository = repository;
    }

    public void salvar(Avaliacao avaliacao) {
        this.repository.save(avaliacao);
    }

    public List<Avaliacao> listar() {

        return this.repository.findAll();
    }

    public Avaliacao getAvaliacao(Long id)
    {
        return this.repository.findById(id).get();
    }

    public void excluir(Long id)
    {
        this.repository.deleteById(id);
    }

    public void atualizar(Avaliacao avaliacao)
    {
        Avaliacao a = this.repository.getReferenceById(avaliacao.getId());

        a.setNota(avaliacao.getNota());
        a.setComentario(avaliacao.getComentario());

        this.repository.save(a);
    }

    public void atualizarUUID(Avaliacao avaliacao)
    {
        Avaliacao a = this.repository.findAvaliacaoByUuid(avaliacao.getUuid());

        if (a == null) {
            throw new RuntimeException(
                    "Avaliação não encontrada com o UUID: " + avaliacao.getUuid()
            );
        }

        a.setNota(avaliacao.getNota());
        a.setComentario(avaliacao.getComentario());

        this.repository.save(a);
    }

    public Avaliacao getAvaliacaoUUID(String uuid)
    {
        UUID uuidformatado = UUID.fromString(uuid);

        return this.repository.findAvaliacaoByUuid(uuidformatado);
    }

    public void deletarUUID(String uuid)
    {
        this.repository.deleteAvaliacaoByUuid(UUID.fromString(uuid));
    }
}