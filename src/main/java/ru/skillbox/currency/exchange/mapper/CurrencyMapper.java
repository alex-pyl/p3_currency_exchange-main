package ru.skillbox.currency.exchange.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.skillbox.currency.exchange.dto.CurrencyDto;
import ru.skillbox.currency.exchange.dto.CurrencyPriceDto;
import ru.skillbox.currency.exchange.entity.Currency;
import ru.skillbox.currency.exchange.xml.CurrencyXml;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {

    CurrencyDto convertToDto(Currency currency);

    Currency convertToEntity(CurrencyDto currencyDto);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name")
    @Mapping(target = "value")
    CurrencyPriceDto convertToPriceDto(Currency currency);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "value", qualifiedByName = "CommaToDouble")
    Currency convertToEntityXml(CurrencyXml currencyXml);

    @Named("CommaToDouble")
    default double localDecimalSeparator(String value) throws ParseException {
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        Number number = format.parse(value);
        return number.doubleValue();
    }
}
