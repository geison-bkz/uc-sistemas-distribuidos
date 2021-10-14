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
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemasdistribuidos.domain.Professor;
import br.com.sistemasdistribuidos.services.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {

    @Autowired
    ProfessorService service;

    @GetMapping("/index")
    public List<Professor> index(){
        return service.all();
    }

    @GetMapping("/show/{id}")
    public Professor store(@PathVariable Integer id){
        return service.find(id);
    }

    @PostMapping("/store")
    public void store(@RequestBody Professor professor){
        service.insert(professor);
    }

    @PutMapping("/update/{id}")
    public Professor update(@PathVariable (name = "id") Integer id, @RequestBody Professor professor){
        return service.update(id, professor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
