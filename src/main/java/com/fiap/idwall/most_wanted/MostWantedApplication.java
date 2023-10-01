package com.fiap.idwall.most_wanted;

import org.jsoup.Jsoup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@SpringBootApplication
public class MostWantedApplication {

	public static void main(String[] args) {
		SpringApplication.run(MostWantedApplication.class, args);

		try {
			// Defina a URL que você deseja raspar
			String url = "https://www.interpol.int/How-we-work/Notices/Red-Notices/View-Red-Notices";

			// Faça uma solicitação HTTP para a página da web
			Document document = Jsoup.connect(url).get();

			// Use seletores CSS para extrair elementos da página
			Elements redNotices = document.select(".red-notice");

			// Itere sobre os elementos e extraia os dados desejados
			for (Element redNotice : redNotices) {
				String title = redNotice.select(".title").text();
				String description = redNotice.select(".description").text();

				System.out.println("Título: " + title);
				System.out.println("Descrição: " + description);
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
