package webScraping.sites.infoJobs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import webScraping.sites.ISite;

public class InfoJobs implements ISite {

	private WebDriver navegador;
	private WebDriverWait aguarde;

	public InfoJobs(WebDriver navegador, WebDriverWait aguarde) {
		this.navegador = navegador;
		this.aguarde = aguarde;
	}

	public void visitarSiteEConsultarVagas(String vagaDeInteresse) {
		try {
			navegador.get("https://www.infojobs.com.br/empregos.aspx?Palabra=" + vagaDeInteresse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> getLinksDasVagas() {
		List<String> listaDeLinks = new ArrayList<>();

		try {
			navegador.findElements(By.cssSelector("div[class=\"vaga \"]"))
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
			navegador.findElements(By.cssSelector("div[class=\"vaga \"]"))
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
		return "InfoJobs";
	}

	@Override
	public void enerrarSite() {
		navegador.quit();
	}

}
