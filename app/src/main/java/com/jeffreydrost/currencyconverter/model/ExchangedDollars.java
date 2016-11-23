package com.jeffreydrost.currencyconverter.model;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class ExchangedDollars {

    public GregorianCalendar asOf;

    public Map<Currency,String> exchanges = new HashMap<Currency,String>();

}
