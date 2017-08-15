package webScraping.encurtadorLinks.googleShortly;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import util.Manipulador;
import webScraping.encurtadorLinks.IEncurtador;

public class GoogleShortly implements IEncurtador {

	public GoogleShortly() {

	}

	@Override
	public String linkEncurtado(String link) {
		Response resposta = null;
		try {
			RestAssured.useRelaxedHTTPSValidation();

			resposta = given().contentType("application/json")
					.queryParam("key", Manipulador.getProp().getProperty("prop.googleShortleyKey").toString())
					.body("{\"longUrl\":\"" + link + "\"}").post("https://www.googleapis.com/urlshortener/v1/url");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resposta.jsonPath().getString("id");
	}

}
