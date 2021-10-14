package br.com.sistemasdistribuidos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemasdistribuidos.domain.Cidade;
import br.com.sistemasdistribuidos.repository.CidadeRepository;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository repository;

    public void insert(Cidade cidade){
        repository.save(cidade);
    }

    public List<Cidade> all(){ return repository.findAll();}

    public Cidade find(Integer id){ return repository.findById(id).get();}

    public void delete(Integer id){ repository.delete(find(id));}

    public Cidade update(Integer id, Cidade cidade) {
        Cidade model = find(id);
        model.setNome(model.getNome());
        model.setNome(model.getNome());
        model.setUf(model.getUf());

        return model;
    }

    public List<Cidade> findByNome(String nome){
        return repository.findByNome(nome);
    }
}
