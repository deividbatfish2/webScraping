package webScraping.sites.vagas;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webScraping.sites.ISite;

public class Vagas implements ISite {

	private WebDriver navegador;
	private WebDriverWait aguarde;

	public Vagas(WebDriver navegador, WebDriverWait aguarde) {
		this.navegador = navegador;
		this.aguarde = aguarde;
	}

	@Override
	public void visitarSiteEConsultarVagas(String vagaDeInteresse) {
		try {
			navegador.get("https://www.vagas.com.br/");
			navegador.findElement(By.id("q")).sendKeys(vagaDeInteresse);
			navegador.findElement(By.id("s")).click();

			aguarde.until(
					ExpectedConditions.visibilityOf(navegador.findElement(By.partialLinkText("Informática/T.I"))));
			navegador.findElement(By.partialLinkText("Informática/T.I")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> getLinksDasVagas() {

		List<String> listaDeLinks = new ArrayList<>();
		try {
			navegador.findElements(By.cssSelector("h2[class=\"cargo\"]"))
					.forEach(div -> listaDeLinks.add(div.findElement(By.tagName("a")).getAttribute("href")));// search
																												// result
																												// links
			return listaDeLinks;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<String> getDescricaoDasVagas() {
		List<String> listaDeDescricao = new ArrayList<>();
		try {
			navegador.findElements(By.cssSelector("h2[class=\"cargo\"]"))
					.forEach(div -> listaDeDescricao.add(div.findElement(By.tagName("a")).getText()));// search
																										// result
																										// links
			return listaDeDescricao;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getNomeSite() {
		return "Vagas";
	}

	@Override
	public void enerrarSite() {
		navegador.quit();
	}

}
