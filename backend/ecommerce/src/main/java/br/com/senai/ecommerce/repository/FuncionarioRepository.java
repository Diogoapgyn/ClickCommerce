package br.com.senai.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.ecommerce.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Short> {

}
