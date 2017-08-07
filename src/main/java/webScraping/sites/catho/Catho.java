package webScraping.sites.catho;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import webScraping.sites.ISite;

public class Catho implements ISite {
	private WebDriver navegador;
	private WebDriverWait aguarde;

	public Catho(WebDriver navegador, WebDriverWait aguarde) {
		this.navegador = navegador;
		this.aguarde = aguarde;
	}

	@Override
	public void visitarSiteEConsultarVagas() {
		navegador.get("https://www.catho.com.br/");
		navegador.findElement(By.id("cargoDesejado")).sendKeys("Teste");
		navegador.findElement(By.cssSelector("input[value=\"buscar\"]")).click();
	}

	@Override
	public List<String> getLinksDasVagas() {
		List<String> listaDeLinks = new ArrayList<>();
		try {

			navegador.findElement(By.id("listagemVagas")).findElements(By.tagName("li"))
					.forEach(li -> listaDeLinks.add(li.findElement(By.tagName("a")).getAttribute("href")));// search
																											// result
																											// links
			navegador.quit();
			return listaDeLinks;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
