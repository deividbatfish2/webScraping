package webScraping.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class DriverManager {

	protected WebDriver navegador;
	protected WebDriverWait aguarde;

	protected abstract void createDriver();

	public void quitDriver() {
		if (null != navegador) {
			navegador.quit();
			navegador = null;
		}

	}

	public WebDriver getDriver() {
		if (null == navegador) {
			createDriver();
		}
		return navegador;
	}

	public WebDriverWait getWait() {
		aguarde = new WebDriverWait(getDriver(), 10);
		return aguarde;
	}
}
