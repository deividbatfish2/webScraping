package webScraping.encurtadorLinks;

import webScraping.encurtadorLinks.Bitly.EncurtadorBitly;
import webScraping.encurtadorLinks.googleShortly.GoogleShortly;

public class EncurtadorDeLinksFactory {
	public static IEncurtador getEncurtador(Encurtadores encurtador) {
		switch (encurtador) {
		case BitLy:
			return new EncurtadorBitly();
		case GoogleShortLy:
			return new GoogleShortly();
		default:
			return new EncurtadorBitly();
		}
	}
}
