package com.swordfish.bdd.senha;

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
	public String gerarCaractere2() {

		String digito = "";
		int random = -1;
		while (this.qtdGerados < QTD_DIGITOS) {
			random = this.gerarIndiceAleatorio(QTD_DIGITOS);

			if (!permiteRepeticao) {
				if (this.digitosGerados[random] == false) {//digito não foi usado ainda
					this.digitosGerados[random] = true;
					qtdGerados++;
					digito = String.valueOf(random);
					break;
				}
			} else {
				digito = String.valueOf(random);
				break;
			}
		}

		return digito;
	}

	@Override
	public String gerarCaractere() {

		String digito = "";
		int random = -1;
		while (this.qtdGerados < QTD_DIGITOS) {
			random = this.gerarIndiceAleatorio(QTD_DIGITOS);

			if (permiteRepeticao) {
				digito = String.valueOf(random);
				break;
			} else {
				if (this.digitosGerados[random] == true) {// digito já foi usado
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
	
	public static void main(String[] args) {

		GeradorCaractere n = new GeradorDigito(false);
		System.out.println(n.gerarCaractere());
		System.out.println(n.gerarCaractere());
		System.out.println(n.gerarCaractere());
		System.out.println(n.gerarCaractere());
		System.out.println(n.gerarCaractere());
		System.out.println(n.gerarCaractere());
		System.out.println(n.gerarCaractere());
		System.out.println(n.gerarCaractere());
		System.out.println(n.gerarCaractere());
		System.out.println(n.gerarCaractere());
		System.out.println(n.gerarCaractere());
	}

}