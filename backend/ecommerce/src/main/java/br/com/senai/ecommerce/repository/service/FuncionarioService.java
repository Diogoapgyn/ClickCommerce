package br.com.senai.ecommerce.repository.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.senai.ecommerce.domain.Funcionario;
import br.com.senai.ecommerce.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	
	public List<Funcionario> listar(){
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		return funcionarios;
	}
	
	public Funcionario buscarPorCodigo(Short codigo){
		Optional<Funcionario> resultado = funcionarioRepository.findById(codigo);
		if(resultado.isEmpty()) {
			throw new RuntimeException("Produto não encontrado");
		}	
		Funcionario funcionarioRetorno = (resultado.get());
		return funcionarioRetorno;
	}
	
	
		public Funcionario inserir(Funcionario funcionario) {
			Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
			//esse produto é pos salvo no banco
			return funcionarioSalvo;
		}
		
		public Funcionario excluir(Short codigo) {
			Optional<Funcionario> funcionario = funcionarioRepository.findById(codigo);
			funcionarioRepository.delete(funcionario.get());
			Funcionario funcRetorno = (funcionario.get());
			return funcRetorno;
		}
		
		public Funcionario editar(Funcionario funcionario) {	
			Funcionario funcionarioEditado = funcionarioRepository.save(funcionario);
			return funcionarioEditado;
		}

}
