package br.com.sistemasdistribuidos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemasdistribuidos.domain.Aluno;
import br.com.sistemasdistribuidos.services.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoResource {

    @Autowired
    AlunoService service;

    @GetMapping("/index")
    public List<Aluno> index(){
        return service.all();
    }

    @GetMapping("/show/{id}")
    public Aluno store(@PathVariable Integer id){
        return service.find(id);
    }

    @PostMapping("/store")
    public void store(@RequestBody Aluno aluno){
        service.insert(aluno);
    }

    @PutMapping("/update/{id}")
    public Aluno update(@PathVariable (name = "id") Integer id, @RequestBody Aluno aluno){
        return service.update(id, aluno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }


    @GetMapping("/search")
    public List<Aluno> search(@RequestParam(name = "nome") String nome){
        return service.findByNome(nome);
    }
}
