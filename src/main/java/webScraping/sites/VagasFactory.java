package webScraping.sites;

import webScraping.driver.DriverManager;
import webScraping.driver.DriverManagerFactory;
import webScraping.driver.DriverType;
import webScraping.sites.bebeeJobs.BebeeJobs;
import webScraping.sites.catho.Catho;
import webScraping.sites.indeed.Indeed;
import webScraping.sites.infoJobs.InfoJobs;
import webScraping.sites.profissionaisti.Profissionaisti;
import webScraping.sites.vagas.Vagas;

public class VagasFactory {

	private static DriverManager driverManager;

	public static ISite getSite(String site) {

		driverManager = DriverManagerFactory.getManager(DriverType.CHROME);

		switch (site) {
		case "https://www.infojobs.com.br/":
			InfoJobs siteInfoJobs = new InfoJobs(driverManager.getDriver(), driverManager.getWait());
			return siteInfoJobs;
		case "https://br.bebee.com/":
			BebeeJobs siteBebbeJobs = new BebeeJobs(driverManager.getDriver(), driverManager.getWait());
			return siteBebbeJobs;
		case "https://www.vagas.com.br/":
			Vagas siteVagas = new Vagas(driverManager.getDriver(), driverManager.getWait());
			return siteVagas;
		case "https://www.indeed.com.br/":
			Indeed siteIndeed = new Indeed(driverManager.getDriver(), driverManager.getWait());
			return siteIndeed;
		case "https://empregos.profissionaisti.com.br/":
			Profissionaisti siteProfissionaisti = new Profissionaisti(driverManager.getDriver(),
					driverManager.getWait());
			return siteProfissionaisti;
		case "https://www.catho.com.br/":
			Catho siteCatho = new Catho(driverManager.getDriver(), driverManager.getWait());
			return siteCatho;

		}

		return null;
	}
}
