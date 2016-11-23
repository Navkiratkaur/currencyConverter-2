package com.jeffreydrost.currencyconverter.model;

import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class ExchangeRates {

    public GregorianCalendar asOf;

    public Map<Currency,BigDecimal> rates = new HashMap<Currency,BigDecimal>();

}
