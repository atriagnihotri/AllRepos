package com.example.crypto;

public class CurrencyModel {
    String name,symbol,price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public CurrencyModel(String name, String symbol, String price) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
    }
}
