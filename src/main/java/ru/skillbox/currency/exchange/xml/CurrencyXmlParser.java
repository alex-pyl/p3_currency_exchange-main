package ru.skillbox.currency.exchange.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class CurrencyXmlParser {
    public CurrencyListXml toObject(String xml){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CurrencyListXml.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (CurrencyListXml) unmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
