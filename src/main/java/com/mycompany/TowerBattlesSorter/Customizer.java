package com.mycompany.TowerBattlesSorter;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;


@Component
public class Customizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
 
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(Integer.parseInt(System.getenv("PORT")));
    }
}

