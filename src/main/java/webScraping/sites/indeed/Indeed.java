package webScraping.sites.indeed;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import webScraping.sites.ISite;

public class Indeed implements ISite {

	private WebDriver navegador;
	private WebDriverWait aguarde;

	public Indeed(WebDriver navegador, WebDriverWait aguarde) {
		this.navegador = navegador;
		this.aguarde = aguarde;
	}

	@Override
	public void visitarSiteEConsultarVagas() {
		try {
			navegador.get("https://www.indeed.com.br/");
			navegador.findElement(By.name("q")).sendKeys("Teste");
			navegador.findElement(By.name("l")).clear();
			navegador.findElement(By.id("fj")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> getLinksDasVagas() {
		List<String> listaDeLinks = new ArrayList<>();

		try {
			navegador.findElements(By.cssSelector("div[class=\"row  result\"]"))
					.forEach(div -> listaDeLinks.add(div.findElement(By.tagName("a")).getAttribute("href")));// search
																												// result
																												// links

			navegador.findElements(By.cssSelector("div[class=\"  row  result\"]"))
					.forEach(div -> listaDeLinks.add(div.findElement(By.tagName("a")).getAttribute("href")));// search
																												// result
																												// links
			navegador.findElements(By.cssSelector("div[class=\"row  result\"]"))
					.forEach(div -> listaDeLinks.add(div.findElement(By.tagName("a")).getAttribute("href")));// search
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
