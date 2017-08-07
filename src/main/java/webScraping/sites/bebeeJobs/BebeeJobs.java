package webScraping.sites.bebeeJobs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webScraping.sites.ISite;

public class BebeeJobs implements ISite {

	private WebDriver navegador;
	private WebDriverWait aguarde;

	public BebeeJobs(WebDriver navegador, WebDriverWait aguarde) {
		this.navegador = navegador;
		this.aguarde = aguarde;
	}

	@Override
	public void visitarSiteEConsultarVagas() {
		try {
			navegador.get("https://br.bebee.com/jobs/search?q=teste");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> getLinksDasVagas() {
		List<String> listaDeLinks = new ArrayList<>();
		try {
			aguarde.until(ExpectedConditions.visibilityOf(navegador.findElement(By.className("job_list_results"))));

			navegador.findElement(By.className("job_list_results")).findElements(By.tagName("li"))
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
