package ru.skillbox.currency.exchange.xml;

import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@NoArgsConstructor
@XmlRootElement(name = "ValCurs")
public class CurrencyListXml {
    private String Date;
    private String name;

    private List<CurrencyXml> currencies;

    public String getDate() {
        return Date;
    }

    @XmlAttribute(name = "Date")
    public void setDate(String date) {
        Date = date;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public List<CurrencyXml> getCurrencies() {
        return currencies;
    }

    @XmlElement(name = "Valute")
    public void setCurrencies(List<CurrencyXml> currencies) {
        this.currencies = currencies;
    }
}
