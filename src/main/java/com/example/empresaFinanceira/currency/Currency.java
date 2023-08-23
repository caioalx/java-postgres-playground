package com.example.empresaFinanceira.currency;

public class Currency {
    private String from;
    private String to;
    private double quote;

    public Currency(String from, String to, double quote) {
        this.from = from;
        this.to = to;
        this.quote = quote;
    }    

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
    public double getQuote() {
        return quote;
    }

    @Override
    public String toString() {
        return "from=" + from + ", to=" + to + ", quote=" + quote;
    }
   
    
}
