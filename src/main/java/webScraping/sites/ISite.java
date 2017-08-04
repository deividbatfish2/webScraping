package webScraping.sites;

import java.util.List;

public interface ISite {

	void visitarSiteEConsultarVagas();

	List<String> getLinksDasVagas();
}
