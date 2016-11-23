package com.jeffreydrost.currencyconverter.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.jeffreydrost.currencyconverter.R;
import com.jeffreydrost.currencyconverter.model.Currency;
import com.jeffreydrost.currencyconverter.model.ExchangedDollars;
import com.jeffreydrost.currencyconverter.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
        presenter.exchangeDollars();
    }

    @DebugLog
    @Override
    public void showExchangedCurrency(ExchangedDollars exchangedDollars) {
        editBrazilReais.setText(exchangedDollars.exchanges.get(Currency.BRL));
        editEUEuro.setText(exchangedDollars.exchanges.get(Currency.EUR));
        editJapanYen.setText(exchangedDollars.exchanges.get(Currency.JPY));
        editUKPounds.setText(exchangedDollars.exchanges.get(Currency.GBP));
    }

    @DebugLog
    @Override
    public void showGettingExchangeRatesError() {
        Toast.makeText(this, "Sorry, we're having a problem retrieving exchange rates. Try again later.", Toast.LENGTH_LONG).show();
    }

    @DebugLog
    @Override
    public String getDollars() {
        return editDollars.getText().toString();
    }

    @DebugLog
    @OnClick(R.id.buttonConvert)
    public void clickConvert() {
        presenter.exchangeDollars();
    }
}
