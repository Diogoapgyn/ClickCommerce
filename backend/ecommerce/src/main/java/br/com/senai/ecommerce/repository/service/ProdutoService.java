package br.com.senai.ecommerce.repository.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.senai.ecommerce.domain.Produto;
import br.com.senai.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	//BUSCAR POR CODIGO
	public Produto buscarPorCodigo(Short codigo){
		Optional<Produto> resultado = produtoRepository.findById(codigo);
		if(resultado.isEmpty()) {
			throw new RuntimeException("Produto não encontrado");
		}	
		Produto produtoRetorno = (resultado.get());
		return produtoRetorno;
	}
	
	//LISTAR TODOS
	public List<Produto> listar(){
		List<Produto> produtos = produtoRepository.findAll();
		return produtos;
	}
	
	//INSERIR
	public Produto inserir(Produto produto) {
		Produto produtoSalvo = produtoRepository.save(produto);
		//esse produto é pos salvo no banco
		return produtoSalvo;
	}
	
	//DELETAR
	public Produto deletar(Short codigo) {
		Optional<Produto> produto = produtoRepository.findById(codigo);
		produtoRepository.delete(produto.get());
		Produto prodRetorno = (produto.get());
		return prodRetorno;
	}
	
	//EDITAR
	public Produto editar(Produto produto) {	
		Produto produtoEditado = produtoRepository.save(produto);
		return produtoEditado;
	}

}
