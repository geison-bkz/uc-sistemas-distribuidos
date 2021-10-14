package br.com.sistemasdistribuidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistemasdistribuidos.domain.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

}
