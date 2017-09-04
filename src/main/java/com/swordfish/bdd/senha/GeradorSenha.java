package com.swordfish.bdd.senha;

import com.swordfish.bdd.senha.model.Configuracao;

public interface GeradorSenha {

	String gerarSenha(Configuracao configuracao); 
}
