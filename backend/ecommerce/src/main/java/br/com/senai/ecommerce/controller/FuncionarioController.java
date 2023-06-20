package br.com.senai.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.ecommerce.domain.Funcionario;
import br.com.senai.ecommerce.repository.service.FuncionarioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping
	public Funcionario inserir(@RequestBody Funcionario funcionario) {
		Funcionario funcionarioSalvo = funcionarioService.inserir(funcionario);
		//esse produto é pos salvo no banco
		return funcionarioSalvo;
	}
	
	@GetMapping("/listar")
	public List<Funcionario> listar() {
		List<Funcionario> funcionarios = funcionarioService.listar();
		return funcionarios;
	}
	
	@DeleteMapping("/{codigo}")
	public Funcionario excluir(@PathVariable Short codigo) {
		Funcionario funciorioExcluido = funcionarioService.excluir(codigo);
		return funciorioExcluido;
	}
	
	@PutMapping
	public Funcionario editar(@RequestBody Funcionario funcionario) {	
		Funcionario funcionarioEditado = funcionarioService.editar(funcionario);
		return funcionarioEditado;
	}

}
