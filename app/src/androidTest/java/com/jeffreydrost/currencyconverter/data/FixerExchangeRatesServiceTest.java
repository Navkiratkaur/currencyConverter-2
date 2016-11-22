package com.jeffreydrost.currencyconverter.data;


import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class FixerExchangeRatesServiceTest {

    @Test
    public void testService() throws Throwable {
        ExchangeRateService service = new ExchangeRateService();
        FixerExchangeRates fixerExchangeRates = service.getFixerExchangeRates();
    }


}
