package com.jeffreydrost.currencyconverter.view;

import com.jeffreydrost.currencyconverter.model.ExchangedDollars;

public interface MainView {

    void showExchangedCurrency(ExchangedDollars exchangedDollars);

    void showGettingExchangeRatesError();

    String getDollars();

}
