package com.swordfish.bdd.features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

import com.swordfish.bdd.senha.model.Configuracao;

import cucumber.api.PendingException;
import cucumber.api.java8.Pt;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class GerarSenhaSpec implements Pt {

	private WebDriver driver;

	@Value("${local.server.port}")
	private int serverPort;

	private Configuracao configuracao;

	private String getUrl() {
		return "http://localhost:" + serverPort;
	}

	public GerarSenhaSpec() {

		Before(() -> {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
			driver = new ChromeDriver();
		});

		Dado("^que o usuário acessou a página$", () -> {
			this.configuracao = new Configuracao();
			this.driver.get(getUrl());
		});

		Quando("^o nome do usuário é \"([^\"]*)\"$", (String arg1) -> {
			configuracao.setNome(arg1);
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("inputNome")));
			driver.findElement(By.id("inputNome")).sendKeys(arg1);
		});

		Quando("^o dia de nascimento é (\\d+)$", (Integer arg1) -> {
			// Write code here that turns the phrase above into concrete actions
			throw new PendingException();
		});

		Quando("^o mes de nascimento é (\\d+)$", (Integer arg1) -> {
			// Write code here that turns the phrase above into concrete actions
			throw new PendingException();
		});

		Quando("^o mes de nascimento é $", () -> {
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

		After(() -> {
			driver.close();
		});

	}
}
