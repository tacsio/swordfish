package com.swordfish.bdd.senha;

import java.util.ArrayList;
import java.util.List;

import com.swordfish.bdd.senha.model.Configuracao;
import com.swordfish.bdd.senha.model.TipoSenha;

public class GeradorSenhaImpl implements GeradorSenha {

	private List<GeradorCaractere> geradores;
	private int qtdGeradores;

	public GeradorSenhaImpl() {
		this.geradores = new ArrayList<>();
	}

	private void criarConfigurarGeradores(Configuracao conf) {

		if (conf.getCaracteresEspeciais()) {
			this.geradores.add(new GeradorCaractereEspecial());
		}
		if (conf.getTipoSenha().equals(TipoSenha.ALFANUMERICO)) {
			this.geradores.add(new GeradorLetra(conf.getMaiuscula()));
			this.geradores.add(new GeradorDigito(conf.getRepeticaoNumeros()));
		} else if (conf.getTipoSenha().equals(TipoSenha.ALFABETICO)) {
			this.geradores.add(new GeradorLetra(conf.getMaiuscula()));
		} else if (conf.getTipoSenha().equals(TipoSenha.NUMERICO)) {
			this.geradores.add(new GeradorDigito(conf.getRepeticaoNumeros()));
		}
		this.qtdGeradores = this.geradores.size();
	}

	private String gerarCaractereAleatorio() {

		int indice = this.geradores.get(0).gerarIndiceAleatorio(this.qtdGeradores);
		return this.geradores.get(indice).gerarCaractere();
	}

	@Override
	public String gerarSenha(Configuracao configuracao) {

		String senha = "";
		this.criarConfigurarGeradores(configuracao);

		while (senha.length() < configuracao.getTamanho()) {

			senha = senha.concat(this.gerarCaractereAleatorio());

			senha = senha.replaceAll(configuracao.getNome(), "");
			senha = senha.replaceAll(String.valueOf(configuracao.getDiaNasc()), "");
			
			//TODO: falta obrigatoriedade de maiscula e caractere especial
			//confirmar se é assim mesmo
		}

		return senha;
	}
	
	public static void main(String[] args) {
		
		Configuracao c = new Configuracao();
		c.setNome("");
		c.setDiaNasc(null);
		c.setCaracteresEspeciais(true);
		c.setMaiuscula(true);
		c.setRepeticaoNumeros(true);
		c.setTamanho(10);
		c.setTipoSenha(TipoSenha.ALFANUMERICO);
		
		GeradorSenhaImpl g = new GeradorSenhaImpl();
		System.out.println(g.gerarSenha(c));
		
	}

}