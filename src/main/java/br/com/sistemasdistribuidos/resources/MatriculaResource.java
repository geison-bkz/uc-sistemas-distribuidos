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

import br.com.sistemasdistribuidos.domain.Matricula;
import br.com.sistemasdistribuidos.services.MatriculaService;

@RestController
@RequestMapping("/matricula")
public class MatriculaResource {

    @Autowired
    MatriculaService service;

    @GetMapping("/index")
    public List<Matricula> index(){
        return service.all();
    }

    @GetMapping("/show/{id}")
    public Matricula store(@PathVariable Integer id){
        return service.find(id);
    }

    @PostMapping("/store")
    public void store(@RequestBody Matricula matricula){
        service.insert(matricula);
    }

    @PutMapping("/update/{id}")
    public Matricula update(@PathVariable (name = "id") Integer id, @RequestBody Matricula matricula){
        return service.update(id, matricula);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
