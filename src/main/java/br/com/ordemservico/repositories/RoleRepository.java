package br.com.ordemservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ordemservico.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}