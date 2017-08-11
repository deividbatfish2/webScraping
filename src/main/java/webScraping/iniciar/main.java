package webScraping.iniciar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Manipulador;
import util.email.JavaMailApp;
import webScraping.relatorio.GeraRelatorio;
import webScraping.relatorio.RelatorioFactory;
import webScraping.sites.ISite;
import webScraping.sites.VagasFactory;

public class main {

	public static void main(String[] args) {

		JavaMailApp email = new JavaMailApp();

		List<String> listaDeSites = new ArrayList<>(
				Arrays.asList(Manipulador.getProp().getProperty("prop.sites").toString().split(";")));

		for (String urlSite : listaDeSites) {
			ISite site = VagasFactory.getSite(urlSite);
			site.visitarSiteEConsultarVagas("Oracle Sql");

			GeraRelatorio relatorio = RelatorioFactory.instaciaRelatorio(site);

			email.setMensagem(relatorio.getRelatorio());
		}
		email.enviarEmail("heitor.cunha.silva@gmail.com");
	}

}
