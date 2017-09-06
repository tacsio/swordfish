package com.swordfish.bdd.senha;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.swordfish.bdd.senha.model.Configuracao;
import com.swordfish.bdd.senha.model.TipoSenha;
import com.swordfish.bdd.util.Util;

@Service
public class GeradorSenhaImpl implements GeradorSenha {

	private List<GeradorCaractere> geradores;
	private Map<String, GeradorCaractere> mapaGeradores;
	private int qtdGeradores;

	private void criarConfigurarGeradores(Configuracao conf) {

		this.geradores = new ArrayList<>();
		this.mapaGeradores = new TreeMap<>();
		this.qtdGeradores = 0;

		if (conf.isCaracteresEspeciais()) {
			GeradorCaractere g = new GeradorCaractereEspecial();
			this.geradores.add(g);
			this.mapaGeradores.put("especial", g);
		}
		if (conf.getTipoSenha().equals(TipoSenha.ALFANUMERICO)) {

			GeradorCaractere g1 = new GeradorLetra(conf.isMaiuscula());
			GeradorCaractere g2 = new GeradorDigito(conf.isRepeticaoNumeros());

			this.geradores.add(g1);
			this.geradores.add(g2);
			this.mapaGeradores.put("letra", g1);
			this.mapaGeradores.put("digito", g2);

		} else if (conf.getTipoSenha().equals(TipoSenha.ALFABETICO)) {

			GeradorCaractere g1 = new GeradorLetra(conf.isMaiuscula());
			this.geradores.add(g1);
			this.mapaGeradores.put("letra", g1);

		} else if (conf.getTipoSenha().equals(TipoSenha.NUMERICO)) {

			GeradorCaractere g2 = new GeradorDigito(conf.isRepeticaoNumeros());
			this.geradores.add(g2);
			this.mapaGeradores.put("digito", g2);

		}
		this.qtdGeradores = this.geradores.size();
	}

	private String gerarSenhaMinimaObrigatoria(Configuracao conf) {

		String senhaMinima = "";
		if (conf.isCaracteresEspeciais()) {
			senhaMinima = senhaMinima.concat(mapaGeradores.get("especial").gerarCaractere());

			if (conf.getTipoSenha().equals(TipoSenha.ALFANUMERICO)) {
				senhaMinima = senhaMinima.concat(mapaGeradores.get("letra").gerarCaractere());
				senhaMinima = senhaMinima.concat(mapaGeradores.get("digito").gerarCaractere());
			} else if (conf.getTipoSenha().equals(TipoSenha.ALFABETICO)) {
				senhaMinima = senhaMinima.concat(mapaGeradores.get("letra").gerarCaractere());
			} else if (conf.getTipoSenha().equals(TipoSenha.NUMERICO)) {
				senhaMinima = senhaMinima.concat(mapaGeradores.get("digito").gerarCaractere());
			}
		} else {
			if (conf.getTipoSenha().equals(TipoSenha.ALFANUMERICO)) {
				senhaMinima = senhaMinima.concat(mapaGeradores.get("letra").gerarCaractere());
				senhaMinima = senhaMinima.concat(mapaGeradores.get("digito").gerarCaractere());
			}
		}
		return senhaMinima;
	}

	private String gerarCaractereAleatorio() {

		int indice = Util.gerarIndiceAleatorio(this.qtdGeradores);
		return this.geradores.get(indice).gerarCaractere();
	}

	@Override
	public String gerarSenha(Configuracao configuracao) {

		String senha = "";
		this.criarConfigurarGeradores(configuracao);
		String senhaMin = this.gerarSenhaMinimaObrigatoria(configuracao);

		while (senhaMin.length() + senha.length() < configuracao.getTamanho()) {

			senha = senha.concat(this.gerarCaractereAleatorio());

			if (configuracao.getNome() != null) {
				senha = senha.replaceAll(configuracao.getNome(), "");
			}
			if (configuracao.getDia() != null && configuracao.getMes() != null) {
				senha = senha.replaceAll(
						String.valueOf(configuracao.getDiaString()) + String.valueOf(configuracao.getMesString()), "");
			}
		}

		return this.misturarStrings(senhaMin, senha);
	}

	private String misturarStrings(String senhaMin, String senha) {

		int tam2 = senha.length();
		String senhaFinal = senha;

		for (int i = 0; i < senhaMin.length(); i++) {
			int indice = Util.gerarIndiceAleatorio(tam2);
			char c1 = senhaMin.charAt(i);
			String part1 = senhaFinal.substring(0, indice);
			String part2 = senhaFinal.substring(indice);
			senhaFinal = part1 + c1 + part2;
			tam2 = senhaFinal.length();
		}

		return senhaFinal;
	}

	public static void main(String[] args) {

		Configuracao c = new Configuracao();
		c.setNome(null);
		c.setDia(1);
		c.setMes(2);
		c.setCaracteresEspeciais(true);
		c.setMaiuscula(true);
		c.setRepeticaoNumeros(false);
		c.setTamanho(10);
		c.setTipoSenha(TipoSenha.ALFANUMERICO);

		GeradorSenhaImpl g = new GeradorSenhaImpl();
		System.out.println(g.gerarSenha(c));
	}

}