package com.jeffreydrost.currencyconverter.data;


import android.support.test.runner.AndroidJUnit4;

import com.jeffreydrost.currencyconverter.domain.ExchangeRates;
import com.jeffreydrost.currencyconverter.domain.FixerExchangeRates;
import com.orhanobut.logger.Logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class FixerExchangeRatesServiceTest {

    private ExchangeRateService service;

    @Before
    public void init() {
        service = new ExchangeRateService();
    }

    @Test
    public void testGetFixerExchangeRates() throws Throwable {
        FixerExchangeRates fixerExchangeRates = service.getFixerExchangeRates();
        assertNotNull(fixerExchangeRates.base);
        assertNotNull(fixerExchangeRates.date);
        assertNotNull(fixerExchangeRates.rates);
    }

    @Test
    public void testGetExchangeRates() throws Throwable {
        ExchangeRates exchangeRates =  service.getExchangeRates();
        assertEquals(4,exchangeRates.rates.size());
        Logger.d(exchangeRates.asOf);
    }

}
