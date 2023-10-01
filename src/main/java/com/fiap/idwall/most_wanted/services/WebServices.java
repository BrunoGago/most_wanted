package com.fiap.idwall.most_wanted.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fiap.idwall.most_wanted.models.WantedFBI;

@Service
public class WebServices {
    @Value("${fbi.url}")
    public String fbiUrl;

    public List<WantedFBI> WebServiceFbi(String complementUrl) throws IOException {

        // Conectar à página da web e definir o User-Agent
        Connection connection = Jsoup.connect(fbiUrl + complementUrl)
                .userAgent(
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.5454.0 Safari/537.36 Edg/105.0.5454.0");

        // Obter o conteúdo HTML
        Document document = connection.get();

        // Encontrar os elementos desejados na página usando seletores CSS
        Elements wantedItems = document.select(".portal-type-person");

        List<WantedFBI> wantedReturn = new ArrayList<>();

        // Iterar pelos elementos e extrair informações
        for (Element item : wantedItems) {
            String crime = item.select(".title").text();
            String name = item.select(".name").text();
            String detailsUrl = item.select("a").first().attr("href");

            Element image = item.select("img").first();
            String imageUrl = image.attr("src");

            WantedFBI wantedTemp = new WantedFBI(crime, name, detailsUrl, imageUrl);

            wantedReturn.add(wantedTemp);

            // System.out.println("Crime: " + crime);
            // System.out.println("Nome: " + name);
            // System.out.println("URL de Detalhes: " + detailsUrl);
            // System.out.println("URL da Imagem: " + imageUrl);

            // System.out.println("--------------------------------------");
        }

        return wantedReturn;
    }

}