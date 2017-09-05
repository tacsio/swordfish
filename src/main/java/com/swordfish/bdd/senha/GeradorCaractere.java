package com.swordfish.bdd.senha;

public interface GeradorCaractere {

	public String gerarCaractere();
	
	default int gerarIndiceAleatorio(int limite){
		return (int) (Math.random() * limite);
	}

}