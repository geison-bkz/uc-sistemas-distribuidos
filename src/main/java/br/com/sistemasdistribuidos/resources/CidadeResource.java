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

import br.com.sistemasdistribuidos.domain.Cidade;
import br.com.sistemasdistribuidos.services.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {

    @Autowired
    CidadeService service;

    @GetMapping("/index")
    public List<Cidade> index(){
        return service.all();
    }

    @GetMapping("/show/{id}")
    public Cidade store(@PathVariable Integer id){
        return service.find(id);
    }

    @PostMapping("/store")
    public void store(@RequestBody Cidade cidade){
        service.insert(cidade);
    }

    @PutMapping("/update/{id}")
    public Cidade update(@PathVariable (name = "id") Integer id, @RequestBody Cidade cidade){
        return service.update(id, cidade);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }


    @GetMapping("/search")
    public List<Cidade> search(@RequestParam(name = "nome") String nome){
        return service.findByNome(nome);
    }
}
