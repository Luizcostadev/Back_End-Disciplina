package br.com.alunoonline.api.controller;
import br.com.alunoonline.api.model.professor;
import br.com.alunoonline.api.service.AlunoService;
import br.com.alunoonline.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    AlunoService alunoService;
    @Autowired
    private ProfessorService professorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarProfessor(@RequestBody professor prof){
        professorService.criarProfessor(prof);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<professor> buscarTodosProfessor(){
        return professorService.buscarTodosProfessor();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<professor> buscarProfessorPorId(@PathVariable Long id){
        return professorService.buscarProfessorPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProfessorPorId(@PathVariable Long id){
        professorService.deletarProfessorPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarProfessorPorId(@PathVariable Long id, @RequestBody professor atualizarProfessor){
        professorService.atualizarProfessorPorId(id, atualizarProfessor);
    }

}