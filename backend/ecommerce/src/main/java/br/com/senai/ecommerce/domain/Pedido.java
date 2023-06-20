package br.com.senai.ecommerce.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
	
	private Short id;
	
	private double total;
	
	private Date date;
	
	private Carrinho carrinho;
	
	//Pessoa faz pedido
	//private Pedido pedido;
	
	//Funcionario faz pedido e acessa pedido de Pessoa
	//private Funcionario funcionario;
	

}
