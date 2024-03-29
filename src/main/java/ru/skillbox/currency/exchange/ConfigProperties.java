package ru.skillbox.currency.exchange;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("repository")
@Setter
@Getter
public class ConfigProperties {

    private String url;
}