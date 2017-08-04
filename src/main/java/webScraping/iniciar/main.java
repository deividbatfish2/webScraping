package webScraping.iniciar;

import webScraping.sites.InfoJobs;

public class main {

	public static void main(String[] args) {
		InfoJobs siteInfoJobs = new InfoJobs();

		siteInfoJobs.visitarSiteEConsultarVagas();

		for (String linkParaVaga : siteInfoJobs.getLinksDasVagas())
			System.out.println(linkParaVaga);
	}

}
