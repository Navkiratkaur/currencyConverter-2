package com.jeffreydrost.currencyconverter.domain;

public enum Currency {

    GBP("GBP","UK Pounds"), EUR("EUR","EU Euro"), JPY("JPY","Japan Yen"), BRL("BRL","Brazil Reais");

    public final String code;

    public final String description;

    Currency(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
