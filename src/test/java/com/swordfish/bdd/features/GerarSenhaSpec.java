package com.swordfish.bdd.features;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.PendingException;
import cucumber.api.java8.Pt;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class GerarSenhaSpec implements Pt {

	public GerarSenhaSpec() {

		Dado("^que o usuário acessou a página$", () -> {
			// Write code here that turns the phrase above into concrete actions
			throw new PendingException();
		});

		Quando("^o nome do usuário é \"([^\"]*)\"$", (String arg1) -> {
			// Write code here that turns the phrase above into concrete actions
			throw new PendingException();
		});

		Quando("^o dia de nascimento é (\\d+)$", (Integer arg1) -> {
			// Write code here that turns the phrase above into concrete actions
			throw new PendingException();
		});

		Quando("^o tamanho da senha é (\\d+)$", (Integer arg1) -> {
			// Write code here that turns the phrase above into concrete actions
			throw new PendingException();
		});

		Quando("^o tamanho da senha é vazio$", () -> {
			// Write code here that turns the phrase above into concrete actions
			throw new PendingException();
		});

		Quando("^a opção de letras maiúscula é \"([^\"]*)\"$", (String arg1) -> {
			// Write code here that turns the phrase above into concrete actions
			throw new PendingException();
		});

		Quando("^a opção de repetição de números é \"([^\"]*)\"$", (String arg1) -> {
			// Write code here that turns the phrase above into concrete actions
			throw new PendingException();
		});

		Quando("^a opção de caracteres especiais é \"([^\"]*)\"$", (String arg1) -> {
			// Write code here that turns the phrase above into concrete actions
			throw new PendingException();
		});

		Quando("^o tipo da senha selecionada é \"([^\"]*)\"$", (String arg1) -> {
			// Write code here that turns the phrase above into concrete actions
			throw new PendingException();
		});

		Então("^O site mostra três possibilidades de senha$", () -> {
			// Write code here that turns the phrase above into concrete actions
			throw new PendingException();
		});

		Então("^as senhas estão válidas de acordo com as opções selecionadas$", () -> {
			// Write code here that turns the phrase above into concrete actions
			throw new PendingException();
		});

		Então("^O site mostra a mensagem de erro: \"([^\"]*)\"$", (String arg1) -> {
			// Write code here that turns the phrase above into concrete actions
			throw new PendingException();
		});

		Então("^O botão de gerar é desabilitado$", () -> {
			// Write code here that turns the phrase above into concrete actions
			throw new PendingException();
		});

	}
}
