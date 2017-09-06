package com.swordfish.bdd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swordfish.bdd.senha.GeradorSenha;
import com.swordfish.bdd.senha.model.Configuracao;

@RestController
public class SenhaController {

	@Autowired
	private GeradorSenha geradorSenha; 
	
	@PostMapping("/senhas")
	public List<String> hello(@RequestBody Configuracao configuracao) {
		
		List<String> lista = new ArrayList<>(3); 
		lista.add(geradorSenha.gerarSenha(configuracao));
		lista.add(geradorSenha.gerarSenha(configuracao));
		lista.add(geradorSenha.gerarSenha(configuracao));

		return lista;
	}
}
