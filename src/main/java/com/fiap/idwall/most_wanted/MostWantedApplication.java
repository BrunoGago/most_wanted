package com.fiap.idwall.most_wanted;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MostWantedApplication {

	public static void main(String[] args) {
		SpringApplication.run(MostWantedApplication.class, args);

		String url = "https://www.fbi.gov/wanted";

		try {

			// Definindo User-Agent para não tomar block da página
			Connection connection = Jsoup.connect(url)
					.userAgent(
							"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.5454.0 Safari/537.36 Edg/117.0.2045.47");

			Document document = connection.get();
			// Esse dá block na página com HTTO 403, falando que não tenho autorização,
			// metodo
			// Jsoup.connect(url).get();

			// Encontre os elementos desejados na página usando seletores CSS
			Elements wantedItems = document.select(".portal-type-person");

			// Iterar pelos elementos e extrair informações
			for (Element item : wantedItems) {
				String name = item.select(".title").text();
				String detailsUrl = "https://www.fbi.gov" + item.select(".title a").attr("href");

				System.out.println("Nome: " + name);
				System.out.println("URL de Detalhes: " + detailsUrl);
				System.out.println("--------------------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
