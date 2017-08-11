package webScraping.relatorio;

import webScraping.relatorio.relatorioWeb.RelatorioWeb;
import webScraping.sites.ISite;

public class RelatorioFactory {

	public static GeraRelatorio instaciaRelatorio(ISite site) {
		return new RelatorioWeb(site);
	}
}
