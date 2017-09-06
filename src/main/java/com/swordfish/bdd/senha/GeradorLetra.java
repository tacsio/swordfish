package com.swordfish.bdd.senha;

import java.util.Random;

import com.swordfish.bdd.util.Util;

public class GeradorLetra implements GeradorCaractere {

	private static String alfabeto = "abcdefghijklmnopqrstuvwxyz";
	private boolean permiteMaiuscula;

	public GeradorLetra(boolean permiteMaiuscula) {
		this.permiteMaiuscula = permiteMaiuscula;
	}

	/**
	 * Gera letra de a-z, ou a-zA-Z.
	 */
	@Override
	public String gerarCaractere() {

		int indice = Util.gerarIndiceAleatorio(alfabeto.length());
		String letra = String.valueOf(GeradorLetra.alfabeto.charAt(indice));

		if (this.permiteMaiuscula) {
			boolean upper = new Random().nextBoolean();
			if (upper) {
				letra = letra.toUpperCase();
			}
		}

		return letra;
	}

}