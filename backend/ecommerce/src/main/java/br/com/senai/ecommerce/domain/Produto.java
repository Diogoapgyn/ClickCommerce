package br.com.senai.ecommerce.domain;


//import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@Column(length = 50, unique = true)
	private String name;
	
	@Column
	private String description;
	
	//precision R$ 700,00 5casas e  scale casa depois da virgula
	@Column
	private double price;
	
	@Column
	private String imageUrl;
	
	@Column
	private boolean isFavorite;
	
	//Funcionario Cadastra Produtos
	//private Funcionario funcionario;

}
