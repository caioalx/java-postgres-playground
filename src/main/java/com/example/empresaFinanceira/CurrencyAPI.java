package com.example.empresaFinanceira;

import java.util.List;
import java.util.NoSuchElementException;

public class CurrencyAPI {
    private static List<Currency> currencyList = 
        List.of(
            new Currency("USD", "BRL", 4.96), 
            new Currency("EUR", "BRL", 5.41),
            new Currency("BRL", "EUR", 0.18));

    public static double getQuote(String from, String to) {
        for(Currency currencyAPI : currencyList) {
            if(currencyAPI.getFrom().equals(from) && currencyAPI.getTo().equals(to)) {
                return currencyAPI.getQuote();
            }
        }

        throw new NoSuchElementException("Não foi encontrada uma quotação para o para de moedas indicado");
    }            
}
