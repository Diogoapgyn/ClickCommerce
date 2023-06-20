package br.com.senai.ecommerce.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short codigo;
	
	@Column
	private Boolean ativo;
	
	@Column(length = 50)
	private String senha;
	
	@Column
	private Character tipo;
	
	//Data de Admissão
    //private Date dataAdmissao;
	
	//Herança de Pessoa
	//Atributos ativo,senha,tipo heradaram de usuario que foi criado depois
		

}
