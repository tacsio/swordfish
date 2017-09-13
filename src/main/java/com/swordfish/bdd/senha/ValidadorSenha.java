package com.swordfish.bdd.senha;

import java.util.regex.Pattern;

import com.swordfish.bdd.senha.exception.SenhaInvalidaException;
import com.swordfish.bdd.senha.model.Configuracao;
import com.swordfish.bdd.senha.model.TipoSenha;

public class ValidadorSenha {

	private static String padraoCaracEspeciais = "[$#&%@_*]";

	private static void validarTamanho(String senha, Configuracao conf) throws SenhaInvalidaException {

		if (senha.length() != conf.getTamanho()) {
			throw new SenhaInvalidaException("Tamanho da senha diferente do especificado.");
		}
	}

	private static void validarPresencaCaracterEspecial(String senha, boolean deveApresentar) throws SenhaInvalidaException {

		if (deveApresentar) {
			if (!Pattern.compile(padraoCaracEspeciais).matcher(senha).find()) {
				throw new SenhaInvalidaException("A senha não apresenta caracteres especiais.");
			}
		} else {
			if (Pattern.compile(padraoCaracEspeciais).matcher(senha).find()) {
				throw new SenhaInvalidaException("A senha não deve apresentar caracteres especiais.");
			}
		}
	}

	private static void validarPresencaSubstring(String senha, String substring) throws SenhaInvalidaException {

		if (senha.indexOf(substring) != -1) {
			throw new SenhaInvalidaException("A senha não pode apresentar a substring: " + substring + ".");
		}
	}

	private static void validarSenhaAlfabeticaComMaiuscula(String senha) throws SenhaInvalidaException {

		if (!Pattern.compile("[A-Z]").matcher(senha).find()) {
			throw new SenhaInvalidaException("Nenhuma letra maiúscula encontrada.");
		}
	}

	private static void validarRepeticaoNumero(String senha) throws SenhaInvalidaException {

		boolean[] digitosGerados = new boolean[10];
		for (int i = 0; i < senha.length(); i++) {
			int digito = Integer.parseInt(senha.substring(i, i + 1));
			if (digitosGerados[digito] == false) {
				digitosGerados[digito] = true;
			} else {
				throw new SenhaInvalidaException("A senha apresenta dígitos repetidos.");
			}
		}
	}

	public static boolean validar(String senha, Configuracao conf) throws SenhaInvalidaException {

		validarTamanho(senha, conf);

		if (conf.getNome() != null) {
			validarPresencaSubstring(senha, conf.getNome());
		}

		if (conf.getDiaNasc() != null && conf.getMesNasc() != null) {
			validarPresencaSubstring(senha, (conf.getDiaString()) + String.valueOf(conf.getMesString()));
		}

		validarPresencaCaracterEspecial(senha, conf.isCaracteresEspeciais());

		String parteNumerica = senha.replaceAll("[a-zA-Z]", "").replaceAll(padraoCaracEspeciais, "");
		String parteAlfabetica = senha.replaceAll("\\d", "").replaceAll(padraoCaracEspeciais, "");

		if (conf.getTipoSenha().equals(TipoSenha.ALFANUMERICO)) {

			if (parteNumerica.equals("")) {
				throw new SenhaInvalidaException("Nenhum dígito encontrado.");
			}
			if (parteAlfabetica.equals("")) {
				throw new SenhaInvalidaException("Nenhuma letra encontrada.");
			}
			if (!conf.isRepeticaoNumeros()) {
				validarRepeticaoNumero(parteNumerica);
			}
			if (conf.isMaiuscula()) {
				validarSenhaAlfabeticaComMaiuscula(senha);
			}

		} else if (conf.getTipoSenha().equals(TipoSenha.ALFABETICO)) {

			if (!parteNumerica.equals("")) {
				throw new SenhaInvalidaException("A senha não pode apresentar dígitos.");
			}
			if (parteAlfabetica.equals("")) {
				throw new SenhaInvalidaException("Nenhuma letra encontrada.");
			}
			if (conf.isMaiuscula()) {
				validarSenhaAlfabeticaComMaiuscula(senha);
			}

		} else if (conf.getTipoSenha().equals(TipoSenha.NUMERICO)) {

			if (parteNumerica.equals("")) {
				throw new SenhaInvalidaException("Nenhum dígito encontrado.");
			}
			if (!parteAlfabetica.equals("")) {
				throw new SenhaInvalidaException("A senha não pode apresentar letras.");
			}
			if (!conf.isRepeticaoNumeros()) {
				validarRepeticaoNumero(parteNumerica);
			}
		}

		return true;
	}

}