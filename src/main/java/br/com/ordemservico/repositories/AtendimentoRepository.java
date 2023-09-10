package br.com.ordemservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ordemservico.entities.Atendimento;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

}
