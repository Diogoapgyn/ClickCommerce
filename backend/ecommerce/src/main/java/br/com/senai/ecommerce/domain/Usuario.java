package br.com.senai.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	
	private Short id;
	
	private String senha;
	
	private Character tipo;
	
	private Boolean ativo;
	
	private Pessoa pessoa;

}
