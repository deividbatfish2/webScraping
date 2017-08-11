package webScraping.sites;

import java.util.List;

public interface ISite {

	void visitarSiteEConsultarVagas(String vagaDeInteresse);

	List<String> getLinksDasVagas();

	List<String> getDescricaoDasVagas();

	String getNomeSite();

	void enerrarSite();
}
