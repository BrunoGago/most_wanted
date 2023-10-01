package com.fiap.idwall.most_wanted.services;

import org.springframework.stereotype.Service;

import com.fiap.idwall.most_wanted.models.WantedInterpol;
import com.fiap.idwall.most_wanted.repositories.InterpolRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Service
public class WebServiceInterpol {

    @Value("${interpol.url}")
    public String interpolUrl;

    @Autowired
    private InterpolRepository repository;

    public List<WantedInterpol> serviceInterpol() throws IOException, InterruptedException {

        // Conecte-se à página da web
        Connection connection = Jsoup.connect(interpolUrl)
                .userAgent(
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.5454.0 Safari/537.36 Edg/105.0.5454.0");

        Document doc = connection.get();

        // Selecione os elementos desejados usando seletores CSS
        Elements redNotices = doc.select(".redNoticeItem__text");

        List<WantedInterpol> wantedReturn = new ArrayList<>();

        // Itere pelos elementos e extraia as informações
        for (Element item : redNotices) {
            String name = item.select(".redNoticeItem__labelLink").text();
            String age = item.select(".ageCount").text();
            String nationality = item.select(".nationalities").text();

            Element image = item.select(".redNoticeItem__responsiveImageContainer").first();
            String imageUrl = image.attr("src");

            WantedInterpol wantedTemp = new WantedInterpol(name, age, nationality, imageUrl);

            wantedReturn.add(wantedTemp);
            Thread.sleep(10);
        }
        return wantedReturn;
    }

    public void insertPersonOnBase() throws IOException, InterruptedException {

        List<WantedInterpol> model = serviceInterpol();
        for (WantedInterpol wanted : model) {
            repository.save(wanted);
        }
    }

    public List<WantedInterpol> getAll() {
        return repository.findAll();
    }

}
