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

import br.com.sistemasdistribuidos.domain.Disciplina;
import br.com.sistemasdistribuidos.services.DisciplinaService;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaResource {

    @Autowired
    DisciplinaService service;

    @GetMapping("/index")
    public List<Disciplina> index(){
        return service.all();
    }

    @GetMapping("/show/{id}")
    public Disciplina store(@PathVariable Integer id){
        return service.find(id);
    }

    @PostMapping("/store")
    public void store(@RequestBody Disciplina disciplina){
        service.insert(disciplina);
    }

    @PutMapping("/update/{id}")
    public Disciplina update(@PathVariable (name = "id") Integer id, @RequestBody Disciplina disciplina){
        return service.update(id, disciplina);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
