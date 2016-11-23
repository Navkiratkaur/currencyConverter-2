package com.jeffreydrost.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.jeffreydrost.currencyconverter.model.Currency;
import com.jeffreydrost.currencyconverter.model.ExchangeRates;
import com.jeffreydrost.currencyconverter.presenter.MainPresenter;
import com.jeffreydrost.currencyconverter.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.editBrazilReais)
    EditText editBrazilReais;

    @BindView(R.id.editDollars)
    EditText editDollars;

    @BindView(R.id.editEUEuro)
    EditText editEUEuro;

    @BindView(R.id.editJapanYen)
    EditText editJapanYen;

    @BindView(R.id.editUKPounds)
    EditText editUKPounds;

    private MainPresenter presenter = null;

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
    }

    @DebugLog
    @Override
    protected void onResume() {
        super.onResume();
        // in case you're out past midnight & leave the app running, onResume vs onCreate for latest exchange rates
        presenter.getExchangeRates();
    }

    @DebugLog
    @Override
    public void updateExchangeRates(ExchangeRates exchangeRates) {
        editBrazilReais.setText(exchangeRates.rates.get(Currency.BRL).toPlainString());
        editEUEuro.setText(exchangeRates.rates.get(Currency.EUR).toPlainString());
        editJapanYen.setText(exchangeRates.rates.get(Currency.JPY).toPlainString());
        editUKPounds.setText(exchangeRates.rates.get(Currency.GBP).toPlainString());
    }

    @DebugLog
    @Override
    public void showGettingExchangeRatesError() {
        // TODO: this

    }
}
