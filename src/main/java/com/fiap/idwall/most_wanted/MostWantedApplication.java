package com.fiap.idwall.most_wanted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MostWantedApplication {

	public static void main(String[] args) {
		SpringApplication.run(MostWantedApplication.class, args);

		// String url = "https://www.fbi.gov/wanted/terrorism";

		// try {
		// // Conectar à página da web e definir o User-Agent
		// Connection connection = Jsoup.connect(url)
		// .userAgent(
		// "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like
		// Gecko) Chrome/105.0.5454.0 Safari/537.36 Edg/105.0.5454.0");

		// // Obter o conteúdo HTML
		// Document document = connection.get();

		// // Encontrar os elementos desejados na página usando seletores CSS
		// Elements wantedItems = document.select(".portal-type-person");

		// // Iterar pelos elementos e extrair informações
		// for (Element item : wantedItems) {
		// String crime = item.select(".title").text();
		// String name = item.select(".name").text();
		// String detailsUrl = item.select("a").first().attr("href");

		// Element image = item.select("img").first();
		// String imageUrl = image.attr("src");

		// System.out.println("Crime: " + crime);
		// System.out.println("Nome: " + name);
		// System.out.println("URL de Detalhes: " + detailsUrl);
		// System.out.println("URL da Imagem: " + imageUrl);

		// System.out.println("--------------------------------------");
		// }
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}
}
