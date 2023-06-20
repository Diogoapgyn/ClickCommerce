package br.com.senai.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
	
	private Short id;
	
	private String nome;
	
	private String cpf;
	
	private String endereco;
	
	private String contato;
	
	private String email;

}
