package br.com.sistemasdistribuidos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemasdistribuidos.domain.Disciplina;
import br.com.sistemasdistribuidos.domain.Professor;
import br.com.sistemasdistribuidos.repository.DisciplinaRepository;
import br.com.sistemasdistribuidos.repository.ProfessorRepository;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository repository;

    @Autowired
    ProfessorRepository professorRepository;

    public void insert(Disciplina disciplina){
        Professor professor = professorRepository.getById(disciplina.getProfessor().getId());

        if(professor != null){
            disciplina.setProfessor(professor);
            repository.save(disciplina);
        }
    }

    public List<Disciplina> all(){ return repository.findAll();}

    public Disciplina find(Integer id){ return repository.findById(id).get();}

    public void delete(Integer id){ repository.delete(find(id));}

    public Disciplina update(Integer id, Disciplina disciplina) {
        Disciplina model = find(id);
        model.setNome(disciplina.getNome());

        Professor professor = professorRepository.getById(disciplina.getProfessor().getId());
        if(professor != null){
            model.setProfessor(professor);
            repository.save(model);

            return model;
        }

        return null;
    }
}
