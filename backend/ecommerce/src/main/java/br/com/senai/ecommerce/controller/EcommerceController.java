package br.com.senai.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ecommerce")
public class EcommerceController {
	
	@RequestMapping("/ola")
	public String exibirMensagem() {
		return "Ola Mundo Spring Boot";
	}

}
