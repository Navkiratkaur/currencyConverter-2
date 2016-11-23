package com.jeffreydrost.currencyconverter.presenter;

import android.os.AsyncTask;

import com.jeffreydrost.currencyconverter.data.ExchangeRateService;
import com.jeffreydrost.currencyconverter.model.ExchangeRates;
import com.jeffreydrost.currencyconverter.view.MainView;
import com.orhanobut.logger.Logger;

import hugo.weaving.DebugLog;

public class MainPresenter {

    private MainView view;

    private ExchangeRateService exchangeRateService = new ExchangeRateService();

    public MainPresenter(MainView view) {
        this.view = view;
    }

    @DebugLog
    public void getExchangeRates() {

        new AsyncTask<Void, Void, ExchangeRates>() {

            @DebugLog
            @Override
            protected ExchangeRates doInBackground(Void... params) {
                try {
                    return exchangeRateService.getExchangeRates();
                } catch (Throwable t) {
                    Logger.e(t,"Encountered error fetching exchange rates");
                    view.showGettingExchangeRatesError();
                    return null;
                }
            }

            @DebugLog
            @Override
            protected void onPostExecute(ExchangeRates exchangeRates) {
                if(exchangeRates != null) {
                    view.updateExchangeRates(exchangeRates);
                } else {
                    Logger.wtf("No exchange rates were given to update!");
                }
            }

        }.execute();

    }

}
