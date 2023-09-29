package com.fiap.idwall.most_wanted.services;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class WebScrappingService {

	private static void rasparDados(){
        //caminho do driver
        System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");

        EdgeOptions options = new EdgeOptions();

        // corrigir possiveis erros
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // evitar deteccao de sites
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", null);

        options.addArguments(("window-size=800,680"));
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36");

        WebDriver driver = new EdgeDriver( options = options);

        driver.get("www.fbi.gov/wanted");
        

    }
    
}
