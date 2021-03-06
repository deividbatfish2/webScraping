package webScraping.sites.profissionaisti;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import webScraping.sites.ISite;

public class Profissionaisti implements ISite {

	private WebDriver navegador;
	private WebDriverWait aguarde;

	public Profissionaisti(WebDriver navegador, WebDriverWait aguarde) {
		this.navegador = navegador;
		this.aguarde = aguarde;
	}

	@Override
	public void visitarSiteEConsultarVagas(String vagaDeInteresse) {
		try {
			navegador.get("https://empregos.profissionaisti.com.br/?s=" + vagaDeInteresse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> getLinksDasVagas() {
		List<String> listaDeLinks = new ArrayList<>();

		try {
			navegador.findElements(By.cssSelector("li[id^=\"vaga\"]"))
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
			navegador.findElements(By.cssSelector("li[id^=\"vaga\"]"))
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
		return "Profissionais TI";
	}

	@Override
	public void enerrarSite() {
		navegador.quit();
	}

}
