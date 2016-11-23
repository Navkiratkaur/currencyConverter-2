package com.jeffreydrost.currencyconverter.data;

import com.jeffreydrost.currencyconverter.model.FixerExchangeRates;

import retrofit2.Call;
import retrofit2.http.GET;

interface FixerExchangeRatesDao {

    @GET("latest?base=USD")
    Call<FixerExchangeRates> getExchangeRates();

}
