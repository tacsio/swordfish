package com.swordfish.bdd.senha.model;

public class Configuracao {
	
	private String nome;
	private Integer diaNasc;
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
	public Integer getDiaNasc() {
		return diaNasc;
	}
	public void setDiaNasc(Integer diaNasc) {
		this.diaNasc = diaNasc;
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
	
	public boolean isValid(){
		//TODO
		return false;
	}
	
	@Override
	public String toString() {
		return "Configuracao [nome=" + nome + ", diaNasc=" + diaNasc + ", tamanho=" + tamanho + ", maiuscula="
				+ maiuscula + ", repeticaoNumeros=" + repeticaoNumeros + ", caracteresEspeciais=" + caracteresEspeciais
				+ ", tipoSenha=" + tipoSenha + "]";
	}
}
