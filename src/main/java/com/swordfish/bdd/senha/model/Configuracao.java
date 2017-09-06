package com.swordfish.bdd.senha.model;

public class Configuracao {
	
	private String nome;
	private Integer dia;
	private Integer mes;
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
	public Integer getDia() {
		return dia;
	}
	public String getDiaString() {
		return String.format("%02d", dia);
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	public Integer getMes() {
		return mes;
	}
	public String getMesString() {
		return String.format("%02d", mes);
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public boolean isValid(){
		//TODO
		return false;
	}

	@Override
	public String toString() {
		return "Configuracao [nome=" + nome + ", dia=" + dia + ", mes=" + mes + ", tamanho=" + tamanho + ", maiuscula="
				+ maiuscula + ", repeticaoNumeros=" + repeticaoNumeros + ", caracteresEspeciais=" + caracteresEspeciais
				+ ", tipoSenha=" + tipoSenha + "]";
	}

}