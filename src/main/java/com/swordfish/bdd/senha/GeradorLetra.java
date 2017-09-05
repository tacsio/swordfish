package com.swordfish.bdd.senha;

import java.util.Random;

public class GeradorLetra implements GeradorCaractere {

	private static String alfabeto = "abcdefghijklmnopqrstuvwxyz";
	private boolean permiteMaiuscula;

	public GeradorLetra(boolean permiteMaiuscula) {
		this.permiteMaiuscula = permiteMaiuscula;
	}

	/**
	 * Gera letra de a à z, ou a à z-A à Z. 
	 */
	@Override
	public String gerarCaractere() {

		int indice = this.gerarIndiceAleatorio(alfabeto.length());
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