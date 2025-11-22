package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Disciplina criarDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> buscarTodasDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Disciplina buscarDisciplinaPorId(Long id) {
        return disciplinaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Disciplina não encontrada com ID: " + id
                ));
    }

    public void deletarDisciplinaPorId(Long id) {
        if (!disciplinaRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Disciplina não encontrada com ID: " + id
            );
        }
        disciplinaRepository.deleteById(id);
    }

    public Disciplina atualizarDisciplina(Long id, Disciplina disciplinaAtualizada) {
        Disciplina disciplinaExistente = buscarDisciplinaPorId(id);

        disciplinaExistente.setNome(disciplinaAtualizada.getNome());


        return disciplinaRepository.save(disciplinaExistente);
    }
}