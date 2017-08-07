package webScraping.iniciar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Manipulador;
import util.email.JavaMailApp;
import webScraping.sites.ISite;
import webScraping.sites.VagasFactory;

public class main {

	public static void main(String[] args) {

		JavaMailApp email = new JavaMailApp();
		int i = 0;

		List<String> listaDeSites = new ArrayList<>(
				Arrays.asList(Manipulador.getProp().getProperty("prop.sites").toString().split(";")));

		for (String urlSite : listaDeSites) {
			ISite site = VagasFactory.getSite(urlSite);
			site.visitarSiteEConsultarVagas();
			try {
				for (String linkParaVaga : site.getLinksDasVagas()) {
					i++;
					System.out.println(i + " - " + linkParaVaga);
					email.setMensagem(i + " - " + linkParaVaga);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		email.enviarEmail();
	}

}
