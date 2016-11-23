package com.jeffreydrost.currencyconverter.presenter;

import android.os.AsyncTask;

import com.jeffreydrost.currencyconverter.data.ExchangeRateService;
import com.jeffreydrost.currencyconverter.model.Currency;
import com.jeffreydrost.currencyconverter.model.ExchangeRates;
import com.jeffreydrost.currencyconverter.model.ExchangedDollars;
import com.jeffreydrost.currencyconverter.view.MainView;
import com.orhanobut.logger.Logger;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

import hugo.weaving.DebugLog;

public class MainPresenter {

    private MainView view;

    private ExchangeRateService exchangeRateService = new ExchangeRateService();

    public MainPresenter(MainView view) {
        this.view = view;
    }

    @DebugLog
    public void convertDollars() {

        view.clearConversions();

        if(isDollarInputInvalid()) {
            view.voidConversions();
            return;
        }

        new AsyncTask<Void, Void, ExchangeRates>() {

            @DebugLog
            @Override
            protected ExchangeRates doInBackground(Void... params) {
                try {
                    return exchangeRateService.getExchangeRates();
                } catch (Throwable t) {
                    Logger.e(t,"Encountered error fetching exchange rates");
                    view.voidConversions();
                    view.showGettingExchangeRatesError();
                    return null;
                }
            }

            @DebugLog
            @Override
            protected void onPostExecute(ExchangeRates exchangeRates) {
                if(exchangeRates != null) {
                    calculateExchangedDollars(exchangeRates);
                } else {
                    Logger.wtf("No exchange rates were given to update!");
                }
            }

        }.execute();

    }

    @DebugLog
    void calculateExchangedDollars(ExchangeRates exchangeRates) {
        ExchangedDollars exchangedDollars = new ExchangedDollars();
        exchangedDollars.asOf = exchangeRates.asOf;

        BigDecimal dollars = new BigDecimal(view.getDollars());
        exchangedDollars.exchanges.put(Currency.BRL,exchangeRates.rates.get(Currency.BRL).multiply(dollars).toPlainString());
        exchangedDollars.exchanges.put(Currency.GBP,exchangeRates.rates.get(Currency.GBP).multiply(dollars).toPlainString());
        exchangedDollars.exchanges.put(Currency.JPY,exchangeRates.rates.get(Currency.JPY).multiply(dollars).toPlainString());
        exchangedDollars.exchanges.put(Currency.EUR,exchangeRates.rates.get(Currency.EUR).multiply(dollars).toPlainString());

        view.showExchangedCurrency(exchangedDollars);
    }

    @DebugLog
    boolean isDollarInputInvalid() {
        Logger.v(view.getDollars().trim());
        return "".equalsIgnoreCase(view.getDollars().trim()) || !StringUtils.isNumeric(view.getDollars());
    }

}
