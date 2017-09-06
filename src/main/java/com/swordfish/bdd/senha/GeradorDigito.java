package com.swordfish.bdd.senha;

import com.swordfish.bdd.util.Util;

public class GeradorDigito implements GeradorCaractere {

	private boolean[] digitosGerados;
	private boolean permiteRepeticao;
	private int qtdGerados;
	private static final int QTD_DIGITOS = 10;

	public GeradorDigito(boolean permiteRepeticao) {
		this.digitosGerados = new boolean[QTD_DIGITOS];
		this.permiteRepeticao = permiteRepeticao;
		this.qtdGerados = 0;
	}

	/**
	 * Gera dígitos de 0 à 9. Se os dígitos esgotarem, gera string vazia.
	 */
	@Override
	public String gerarCaractere() {

		String digito = "";
		int random = -1;
		while (this.qtdGerados < QTD_DIGITOS) {
			random = Util.gerarIndiceAleatorio(QTD_DIGITOS);

			if (permiteRepeticao) {
				digito = String.valueOf(random);
				break;
			} else {
				// digito já foi usado
				if (this.digitosGerados[random] == true) {
					continue;
				} else {
					this.digitosGerados[random] = true;
					qtdGerados++;
					digito = String.valueOf(random);
					break;
				}
			}
		}

		return digito;
	}

}