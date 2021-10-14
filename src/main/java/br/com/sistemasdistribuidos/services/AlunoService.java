package br.com.sistemasdistribuidos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemasdistribuidos.domain.Aluno;
import br.com.sistemasdistribuidos.domain.Cidade;
import br.com.sistemasdistribuidos.repository.AlunoRepository;
import br.com.sistemasdistribuidos.repository.CidadeRepository;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository;

    @Autowired
    CidadeRepository cidadeRepository;

    public void insert(Aluno aluno){
        Cidade cidade = cidadeRepository.getById(aluno.getCidade().getId());
        if(cidade != null){
            aluno.setCidade(cidade);
            repository.save(aluno);
        }
    }

    public List<Aluno> all(){ return repository.findAll();}

    public Aluno find(Integer id){ return repository.findById(id).get();}

    public void delete(Integer id){ repository.delete(find(id));}

    public Aluno update(Integer id, Aluno aluno) {
        Aluno model = find(id);
        model.setNome(model.getNome());
        model.setN1(model.getN1());
        model.setN2(model.getN2());
        model.setN3(model.getN3());

        Cidade cidade = cidadeRepository.getById(aluno.getCidade().getId());
        if(cidade != null){
            model.setCidade(cidade);
            repository.save(model);

            return model;
        }

        return null;
    }

    public List<Aluno> findByNome(String nome){
        return repository.findByNome(nome);
    }
}
