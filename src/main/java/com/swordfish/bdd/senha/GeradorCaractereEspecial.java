package com.swordfish.bdd.senha;

import com.swordfish.bdd.util.Util;

public class GeradorCaractereEspecial implements GeradorCaractere {

	private static String especiais = "$#&%@_*";

	/**
	 * Gera um caractere especial entre $#&%@_*.
	 */
	@Override
	public String gerarCaractere() {

		int indice = Util.gerarIndiceAleatorio(especiais.length());
		return String.valueOf(GeradorCaractereEspecial.especiais.charAt(indice));
	}

}