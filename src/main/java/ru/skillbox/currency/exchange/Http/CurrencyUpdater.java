package ru.skillbox.currency.exchange.Http;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import ru.skillbox.currency.exchange.ConfigProperties;
import ru.skillbox.currency.exchange.mapper.CurrencyMapper;
import ru.skillbox.currency.exchange.repository.CurrencyRepository;
import ru.skillbox.currency.exchange.xml.CurrencyListXml;
import ru.skillbox.currency.exchange.xml.CurrencyXml;
import ru.skillbox.currency.exchange.xml.CurrencyXmlParser;

@Slf4j
@RequiredArgsConstructor
@Configuration
@EnableScheduling
public class CurrencyUpdater {
    private final ConfigProperties configProperties;
    private final CurrencyMapper mapper;
    private final CurrencyRepository repository;

    public String getCurrencyXml() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(configProperties.getUrl(), String.class);
    }

    @Scheduled(fixedDelay = 1000*60*60, initialDelay = 0)
    public void load() {
        log.info("Currency start loading");
        String xml = getCurrencyXml();
        CurrencyXmlParser parser = new CurrencyXmlParser();
        CurrencyListXml currencyListXml = parser.toObject(xml);
        for(CurrencyXml currencyXml: currencyListXml.getCurrencies()){
            repository.save(mapper.convertToEntityXml(currencyXml));
        }
        log.info("Currency loaded successfully");
    }
}
