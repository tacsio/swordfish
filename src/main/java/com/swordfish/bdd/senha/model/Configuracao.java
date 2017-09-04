package com.swordfish.bdd.senha.model;

public class Configuracao {
	
	private String nome;
	private Integer diaNasc;
	private Integer tamanho;
	private Boolean maiuscula;
	private Boolean repeticaoNumeros;
	private Boolean caracteresEspeciais;
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
	public Boolean getMaiuscula() {
		return maiuscula;
	}
	public void setMaiuscula(Boolean maiuscula) {
		this.maiuscula = maiuscula;
	}
	public Boolean getRepeticaoNumeros() {
		return repeticaoNumeros;
	}
	public void setRepeticaoNumeros(Boolean repeticaoNumeros) {
		this.repeticaoNumeros = repeticaoNumeros;
	}
	public Boolean getCaracteresEspeciais() {
		return caracteresEspeciais;
	}
	public void setCaracteresEspeciais(Boolean caracteresEspeciais) {
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
