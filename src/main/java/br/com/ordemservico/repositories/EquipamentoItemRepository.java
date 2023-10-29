package br.com.ordemservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ordemservico.entities.EquipamentoItem;

public interface EquipamentoItemRepository extends JpaRepository<EquipamentoItem, Long>{

}
