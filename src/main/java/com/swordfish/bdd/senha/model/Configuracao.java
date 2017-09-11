package com.swordfish.bdd.senha.model;

public class Configuracao {

	private String nome;
	private Integer diaNasc;
	private Integer mesNasc;
	private Integer tamanho;
	private boolean maiuscula;
	private boolean repeticaoNumeros;
	private boolean caracteresEspeciais;
	private TipoSenha tipoSenha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	public boolean isMaiuscula() {
		return maiuscula;
	}

	public void setMaiuscula(boolean maiuscula) {
		this.maiuscula = maiuscula;
	}

	public boolean isRepeticaoNumeros() {
		return repeticaoNumeros;
	}

	public void setRepeticaoNumeros(boolean repeticaoNumeros) {
		this.repeticaoNumeros = repeticaoNumeros;
	}

	public boolean isCaracteresEspeciais() {
		return caracteresEspeciais;
	}

	public void setCaracteresEspeciais(boolean caracteresEspeciais) {
		this.caracteresEspeciais = caracteresEspeciais;
	}

	public TipoSenha getTipoSenha() {
		return tipoSenha;
	}

	public void setTipoSenha(TipoSenha tipoSenha) {
		this.tipoSenha = tipoSenha;
	}

	public Integer getDiaNasc() {
		return diaNasc;
	}

	public String getDiaString() {
		return String.format("%02d", diaNasc);
	}

	public void setDiaNasc(Integer dia) {
		this.diaNasc = dia;
	}

	public Integer getMesNasc() {
		return mesNasc;
	}

	public String getMesString() {
		return String.format("%02d", mesNasc);
	}

	public void setMesNasc(Integer mes) {
		this.mesNasc = mes;
	}

	public boolean isValid() {

		if (tipoSenha.equals(TipoSenha.ALFABETICO)) {
			if (repeticaoNumeros) {
				throw new IllegalArgumentException(
						"Não é possível gerar uma senha do tipo alfabética com repetição de números.");
			}
		}

		if (tipoSenha.equals(TipoSenha.NUMERICO)) {
			if (maiuscula) {
				throw new IllegalArgumentException(
						"Não é possível gerar uma senha do tipo numérica com letras maiúsculas.");
			}
		}

		if ((diaNasc == null) ^ (mesNasc == null)) {
			throw new IllegalArgumentException(
					"Não é possível gerar uma senha informando apenas dia ou mês de nascimento.");
		}

		if (tamanho != null) {
			if (tamanho < 5 || tamanho > 10) {
				throw new IllegalArgumentException("Informe um tamanho de senha entre 5 e 10.");
			}
		} else {
			throw new IllegalArgumentException("O campo de tamanho de senha deve ser preenchido.");
		}

		return true;
	}

	@Override
	public String toString() {
		return "Configuracao [nome=" + nome + ", diaNasc=" + diaNasc + ", mesNasc=" + mesNasc + ", tamanho=" + tamanho + ", maiuscula="
				+ maiuscula + ", repeticaoNumeros=" + repeticaoNumeros + ", caracteresEspeciais=" + caracteresEspeciais
				+ ", tipoSenha=" + tipoSenha + "]";
	}

	public boolean validate(String s) {
		//TODO;
		return true;
	}

}