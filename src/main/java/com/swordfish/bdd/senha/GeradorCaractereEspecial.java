package com.swordfish.bdd.senha;

public class GeradorCaractereEspecial implements GeradorCaractere {

	private static String especiais = "$#&%@_*";

	public GeradorCaractereEspecial() {}

	/**
	 * Gera caractere especial entre $#&+?!%@_-.
	 */
	@Override
	public String gerarCaractere() {

		int indice = this.gerarIndiceAleatorio(especiais.length());
		return String.valueOf(GeradorCaractereEspecial.especiais.charAt(indice));
	}

}