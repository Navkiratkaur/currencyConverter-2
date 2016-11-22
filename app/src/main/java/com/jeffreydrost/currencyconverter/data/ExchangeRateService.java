package com.jeffreydrost.currencyconverter.data;

import java.io.IOException;

import hugo.weaving.DebugLog;
import retrofit2.Call;
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

}
