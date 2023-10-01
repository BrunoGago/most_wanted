package com.fiap.idwall.most_wanted;

import java.io.IOException;

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

	}
}
