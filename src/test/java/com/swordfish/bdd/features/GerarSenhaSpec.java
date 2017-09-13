package com.swordfish.bdd.features;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

import com.swordfish.bdd.senha.model.Configuracao;
import com.swordfish.bdd.senha.model.TipoSenha;

import cucumber.api.java8.Pt;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class GerarSenhaSpec implements Pt {

	private WebDriver driver;

	@Value("${local.server.port}")
	private int serverPort;

	private Configuracao configuracao;
	
	private List<String> senhas;

	private String getUrl() {
		return "http://localhost:" + serverPort;
	}

	public GerarSenhaSpec() {

		Before(() -> {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
			if(System.getProperty("os.name").toLowerCase().contains("win")) {
				System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			}
			driver = new ChromeDriver();
		});

		Dado("^que o usuário acessou a página$", () -> {
			this.configuracao = new Configuracao();
			this.senhas = new ArrayList<>();
			this.driver.get(getUrl());
		});

		Quando("^o nome do usuário é \"([^\"]*)\"$", (String arg1) -> {
			configuracao.setNome(arg1);
			visibilityOfElementLocated(By.id("inputNome"));
			driver.findElement(By.id("inputNome")).sendKeys(arg1);
		});

		Quando("^o dia de nascimento é (\\d+)$", (Integer arg1) -> {
			configuracao.setDiaNasc(arg1);
			visibilityOfElementLocated(By.id("inputDiaNasc"));
			driver.findElement(By.id("inputDiaNasc")).sendKeys(arg1+"");
		});
		
		Quando("^o mes de nascimento é $", () -> {
			configuracao.setMesNasc(null);
		});
		

		Quando("^o mes de nascimento é (\\d+)$", (Integer arg1) -> {
			configuracao.setMesNasc(arg1);
			visibilityOfElementLocated(By.id("inputMesNasc"));
			driver.findElement(By.id("inputMesNasc")).sendKeys(arg1+"");
		});


		Quando("^o tamanho da senha é (\\d+)$", (Integer arg1) -> {
			configuracao.setTamanho(arg1);
			visibilityOfElementLocated(By.id("inputTamanho"));
			driver.findElement(By.id("inputTamanho")).sendKeys(arg1+"");
		});

		Quando("^o tamanho da senha é vazio$", () -> {
			configuracao.setTamanho(0);
			visibilityOfElementLocated(By.id("inputTamanho"));
			driver.findElement(By.id("inputTamanho")).sendKeys("");
		});

		Quando("^a opção de letras maiúscula é \"([^\"]*)\"$", (String arg1) -> {
			boolean marcado = false;
			
			if(arg1.equalsIgnoreCase("marcada")) {
				marcado =true;
			} else {
				marcado =false;
			}
			
			configuracao.setMaiuscula(marcado);
			visibilityOfElementLocated(By.id("checkMaiuscula"));

			if(marcado) {
				driver.findElement(By.id("checkMaiuscula")).click();
			}
		});

		Quando("^a opção de repetição de números é \"([^\"]*)\"$", (String arg1) -> {
			boolean marcado = false;
			
			if(arg1.equalsIgnoreCase("marcada")) {
				marcado =true;
			} else {
				marcado =false;
			}
			
			configuracao.setRepeticaoNumeros(marcado);
			visibilityOfElementLocated(By.id("checkRepeticao"));

			if(marcado) {
				driver.findElement(By.id("checkRepeticao")).click();
			}
		});

		Quando("^a opção de caracteres especiais é \"([^\"]*)\"$", (String arg1) -> {
			boolean marcado = false;
			
			if(arg1.equalsIgnoreCase("marcada")) {
				marcado =true;
			} else {
				marcado =false;
			}
			
			configuracao.setCaracteresEspeciais(marcado);
			visibilityOfElementLocated(By.id("checkCaracEspeciais"));

			if(marcado) {
				driver.findElement(By.id("checkCaracEspeciais")).click();
			}
		});

		Quando("^o tipo da senha selecionada é \"([^\"]*)\"$", (String arg1) -> {
			
			TipoSenha tipo = null;
			
			if(arg1.trim().equalsIgnoreCase("numérica")) {
				tipo = TipoSenha.NUMERICO;
			} else if(arg1.trim().equalsIgnoreCase("alfabética")) {
				tipo = TipoSenha.ALFABETICO;
			} else if(arg1.trim().equalsIgnoreCase("alfanumérica")) {
				tipo = TipoSenha.ALFANUMERICO;
			}
						configuracao.setTipoSenha(tipo);
			visibilityOfElementLocated(By.id("checkCaracEspeciais"));
			driver.findElement(By.cssSelector("md-radio-button[value="+ tipo + "]")).click();
		});
		
		Quando("^o usuário clica em gerar senha$", () -> {
			driver.findElement(By.id("botaoGerar")).click();
		});

		
		/* ----------------- THEN -----------------*/
		
		Então("^O site mostra três possibilidades de senha$", () -> {
			visibilityOfElementLocated(By.tagName("md-list-item"));
			driver.findElements(By.tagName("md-list-item"))
				.stream()
				.map(WebElement::getText)
				.forEach(senhas::add);
			
			assertThat(3, is(senhas.size()));
		});

		Então("^as senhas estão válidas de acordo com as opções selecionadas$", () -> {
			senhas.forEach(s -> {
				
				boolean valid = configuracao.validate(s);
				
				assertThat(true, is(valid));
			});
		});

		Então("^O site mostra a mensagem de erro: \"([^\"]*)\"$", (String arg1) -> {
			visibilityOfElementLocated(By.cssSelector("#dialogErro > md-dialog"));
			String msg = driver.findElement(By.id("msgDialogErro")).getText();

			assertThat(arg1, is(msg));
		});
		
		Então("^O site mostra a notificacao de erro de preenchimento do tamanho da senha$", () -> {
			visibilityOfElementLocated(flashErrorMessageFromInputId("inputTamanho"));
			String msg = driver.findElement(flashErrorMessageFromInputId("inputTamanho")).getText();

			assertThat("O campo de tamanho de senha deve ser preenchido.", is(msg));
		});

		Então("^O site mostra a notificacao de erro de tamanho de senha$", () -> {
			visibilityOfElementLocated(flashErrorMessageFromInputId("inputTamanho"));
			String msg = driver.findElement(flashErrorMessageFromInputId("inputTamanho")).getText();

			assertThat("Informe um tamanho de senha entre 5 e 10.", is(msg));
		});
		

		Então("^O botão de gerar é desabilitado$", () -> {
			boolean enabled = driver.findElement(By.id("botaoGerar")).isEnabled();
			assertThat(enabled, Matchers.is(false));
		});

		After(() -> {
			driver.close();
		});
	}
	
	private By flashErrorMessageFromInputId(String inputId) {
		return By.cssSelector("div[ng-messages='form." + inputId +".$error']");
	}
	
	private void visibilityOfElementLocated(By location) {
		visibilityOfElementLocated(location, 5);
	}
	
	private void visibilityOfElementLocated(By location, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(location));
	}
}
