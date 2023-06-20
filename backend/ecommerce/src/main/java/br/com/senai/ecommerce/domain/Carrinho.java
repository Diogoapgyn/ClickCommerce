package br.com.senai.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carrinho {

	private Short id;
	
	private String name;
	
	private int quantity;
	
	private double price;
	
	private Produto produto;
	
	private Pedido pedido;
}
