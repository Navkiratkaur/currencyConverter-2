package com.jeffreydrost.currencyconverter.view;

import com.jeffreydrost.currencyconverter.model.ExchangeRates;

public interface MainView {

    void updateExchangeRates(ExchangeRates exchangeRates);

    void showGettingExchangeRatesError();

}
