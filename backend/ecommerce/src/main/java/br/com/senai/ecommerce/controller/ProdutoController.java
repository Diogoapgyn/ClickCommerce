package br.com.senai.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import br.com.senai.ecommerce.domain.Produto;

import br.com.senai.ecommerce.repository.service.ProdutoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/{codigo}")
	public Produto buscarPorCodigo(@PathVariable Short codigo) {
		// PatchVariable amarra o atributo codigo do parametro acima no {codigo} do
		// DeleteMapping
		Produto produto = produtoService.buscarPorCodigo(codigo);
		return produto;
	}

	@GetMapping("/listar")
	public List<Produto> listar() {
		List<Produto> produtos = produtoService.listar();
		return produtos;
	}
	
	//@RequestMapping(value = "/", method = RequestMethod.POST)
	//@PostMapping
	@RequestMapping(value="/inserir", method =RequestMethod.POST)
	public Produto inserir(@RequestBody Produto produto) {
		Produto produtoSalvo = produtoService.inserir(produto);
		//esse produto é pos salvo no banco
		return produtoSalvo;
	}
	
	@DeleteMapping("/{codigo}")
	public Produto excluir(@PathVariable Short codigo) {
		Produto produtoExcluido = produtoService.deletar(codigo);
		return produtoExcluido;
	}
	@PatchMapping
	public Produto editar(@RequestBody Produto produto) {	
		Produto produtoEditado = produtoService.editar(produto);
		return produtoEditado;
	}
	

	// Trazer todos os produtos
//	@GetMapping("/listar")
//	public List<Produto> listar(){
//		List<Produto> produtos = produtoRepository.findAll();
//		return produtos;
//	}	
//	@GetMapping("/{codigo}")
//	public Produto buscar(@PathVariable Short codigo) {
//		//PatchVariable amarra o atributo codigo do parametro acima no {codigo} do DeleteMapping
//		Optional<Produto> resultado = produtoRepository.findById(codigo);
//		Produto produtoRetorno = (resultado.get());
//		return produtoRetorno;
//	}	
//	//produto do parametro abaixo é o pre objeto ao enviar
//	@PostMapping
//	public Produto inserir(@RequestBody Produto produto) {
//		Produto produtoSalvo = produtoRepository.save(produto);
//		//esse produto é pos salvo no banco
//		return produtoSalvo;
//	}
//	
//	//mapear atraves do /{atributo}
//	@DeleteMapping("/{codigo}")
//	public Produto excluir(@PathVariable Short codigo) {
//		//PatchVariable amarra o atributo codigo do parametro acima no {codigo} do DeleteMapping
//		Optional<Produto> produto = produtoRepository.findById(codigo);
//		produtoRepository.delete(produto.get());
//		Produto produtoRetorno = (produto.get());
//		return produtoRetorno;
//	}
//	
//	@PutMapping
//	public Produto editar(@RequestBody Produto produto) {
//		Produto produtoEditado = produtoRepository.save(produto);
//		return produtoEditado;
//	}
}
