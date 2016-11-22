package com.jeffreydrost.currencyconverter.data;

import com.jeffreydrost.currencyconverter.domain.Currency;
import com.jeffreydrost.currencyconverter.domain.ExchangeRates;
import com.jeffreydrost.currencyconverter.domain.FixerExchangeRates;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import hugo.weaving.DebugLog;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExchangeRateService {

    @DebugLog
    FixerExchangeRates getFixerExchangeRates() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.fixer.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FixerExchangeRatesDao service = retrofit.create(FixerExchangeRatesDao.class);
        return service.getExchangeRates().execute().body();
    }

    @DebugLog
    public ExchangeRates getExchangeRates() throws IOException, ParseException {
        return convert(getFixerExchangeRates());
    }

    // TODO: this should be in its own class (single responsibility principle + easier testing)
    @DebugLog
    ExchangeRates convert(FixerExchangeRates fixerRates) throws IOException, ParseException {
        ExchangeRates exchangeRates = new ExchangeRates();

        Date asDateType = new SimpleDateFormat("yyyy-MM-dd").parse(fixerRates.date);
        exchangeRates.asOf = new GregorianCalendar();
        exchangeRates.rates.put(Currency.BRL,fixerRates.rates.get(Currency.BRL.code));
        exchangeRates.rates.put(Currency.EUR,fixerRates.rates.get(Currency.EUR.code));
        exchangeRates.rates.put(Currency.GBP,fixerRates.rates.get(Currency.GBP.code));
        exchangeRates.rates.put(Currency.JPY,fixerRates.rates.get(Currency.JPY.code));

        return exchangeRates;
    }

}
