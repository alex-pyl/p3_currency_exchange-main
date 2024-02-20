package ru.skillbox.currency.exchange.xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Getter
public class CurrencyXml {
    private String id;
    private String isoNumCode;
    private String isoCharCode;
    private Long nominal;
    private String name;
    private String value;
    private String nominalValue;

    @XmlAttribute(name = "ID")
    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "NumCode")
    public void setIsoNumCode(String isoNumCode) {
        this.isoNumCode = isoNumCode;
    }

    @XmlElement(name = "CharCode")
    public void setIsoCharCode(String isoCharCode) {
        this.isoCharCode = isoCharCode;
    }

    @XmlElement(name = "Nominal")
    public void setNominal(Long nominal) {
        this.nominal = nominal;
    }

    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "Value")
    public void setValue(String value) {
        this.value = value;
    }

    @XmlElement(name = "VunitRate")
    public void setNominalValue(String nominalValue) {
        this.nominalValue = nominalValue;
    }
}
