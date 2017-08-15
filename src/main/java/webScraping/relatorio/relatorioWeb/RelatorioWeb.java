package webScraping.relatorio.relatorioWeb;

import java.util.List;

import webScraping.encurtadorLinks.EncurtadorDeLinksFactory;
import webScraping.encurtadorLinks.Encurtadores;
import webScraping.encurtadorLinks.IEncurtador;
import webScraping.relatorio.GeraRelatorio;
import webScraping.sites.ISite;

public class RelatorioWeb implements GeraRelatorio {

	private String relatorio;
	private ISite site;
	private IEncurtador encurtadorLink;

	public RelatorioWeb(ISite site) {
		this.relatorio = "";
		this.site = site;
		this.encurtadorLink = EncurtadorDeLinksFactory.getEncurtador(Encurtadores.GoogleShortLy);
	}

	@Override
	public String getRelatorio() {
		List<String> listaDeVagas = this.site.getLinksDasVagas();
		List<String> listaDeDescricaoVaga = this.site.getDescricaoDasVagas();

		try {
			if (listaDeVagas.size() > 0) {
				this.relatorio += this.site.getNomeSite() + "\n\n";
				this.relatorio += "Vagas: \n";
				for (int i = 0; i < listaDeVagas.size(); i++) {
					System.out.println((i + 1) + " - " + listaDeVagas.get(i));
					this.relatorio += (i + 1) + " - " + listaDeDescricaoVaga.get(i) + " - link: "
							+ encurtadorLink.linkEncurtado(listaDeVagas.get(i)) + "\n";

				}
				this.relatorio += "\n\n\n";
				site.enerrarSite();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return relatorio;
	}

}
