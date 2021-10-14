package br.com.sistemasdistribuidos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemasdistribuidos.domain.Professor;
import br.com.sistemasdistribuidos.repository.ProfessorRepository;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository repository;

    public void insert(Professor professor){
        repository.save(professor);
    }

    public List<Professor> all(){ return repository.findAll();}

    public Professor find(Integer id){ return repository.findById(id).get();}

    public void delete(Integer id){ repository.delete(find(id));}

    public Professor update(Integer id, Professor professor) {
        Professor model = find(id);
        model.setNome(model.getNome());
        model.setFormacao(model.getFormacao());
        repository.save(model);

        return model;
    }
}
