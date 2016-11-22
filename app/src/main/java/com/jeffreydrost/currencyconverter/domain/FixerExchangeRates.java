package com.jeffreydrost.currencyconverter.domain;

import java.math.BigDecimal;
import java.util.HashMap;

public class FixerExchangeRates {

    public String base;

    public String date;

    public HashMap<String,BigDecimal> rates;

}
