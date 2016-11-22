package com.jeffreydrost.currencyconverter.data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FixerExchangeRatesDao {

    @GET("latest?base=USD")
    Call<FixerExchangeRates> getExchangeRates();

}
