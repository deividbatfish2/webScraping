package webScraping.sites;

import java.util.ArrayList;
import java.util.List;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

public class InfoJobs implements ISite {

	UserAgent userAgent = new UserAgent();

	public void visitarSiteEConsultarVagas() {
		try {
			userAgent.visit("https://www.infojobs.com.br/empregos.aspx?Palabra=teste");
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<String> getLinksDasVagas() {
		Elements links = userAgent.doc.findEvery("<div class=\"vaga \">").findEvery("<a>"); // find
																							// search
																							// result
																							// links

		List<String> listaDeLinks = new ArrayList<String>();
		for (Element link : links)
			try {
				listaDeLinks.add(link.getAt("href"));
			} catch (NotFound e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // print results
		return listaDeLinks;
	}

}
