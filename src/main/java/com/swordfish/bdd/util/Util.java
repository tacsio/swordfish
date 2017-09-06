package com.swordfish.bdd.util;

public class Util {

	/**
	 * Gera um inteiro não negativo aleatório entre 0 e o quantidade-1.
	 * 
	 * @param quantidade - quantidade de numeros possíveis.
	 * @return int
	 */
	public static int gerarIndiceAleatorio(int quantidade) {
		if (quantidade > 0) {
			return (int) (Math.random() * quantidade);
		} else {
			throw new IllegalArgumentException();
		}
	}

}