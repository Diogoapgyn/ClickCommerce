package br.com.senai.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.ecommerce.domain.Produto;

//CONTEM TODOS OS METODOS SAVE,DELETE,LIST
public interface ProdutoRepository extends JpaRepository<Produto,Short> {

}
