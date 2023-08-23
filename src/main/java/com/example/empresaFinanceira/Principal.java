package com.example.empresaFinanceira;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import com.example.empresaFinanceira.currency.CurrencyAPI;
import com.example.empresaFinanceira.dao.TransacaoDAO;
import com.example.empresaFinanceira.model.Transacao;
import com.example.empresaFinanceira.yahooFinance.YahooFinanceData;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class Principal {
    
    private static final String ADDRESS = "https://query1.finance.yahoo.com/v7/finance/spark?symbols=USDBRL=X";

    public static void main(String[] args) {
        simulatedAPIRequest();
        yahooFinanceRequest();

        var dao = new TransacaoDAO();

        dao.adicionar(new Transacao("Caio", 100, "USD", 'D'));
        dao.adicionar(new Transacao("Caio", 100, "BRL", 'D'));
        dao.adicionar(new Transacao("Caio", 10, "BRL", 'T'));
        dao.adicionar(new Transacao("Caio", 20, "BRL", 'D'));
        dao.adicionar(new Transacao("Caio", 5, "BRL", 'R'));
        dao.adicionar(new Transacao("Cintia", 20, "EUR", 'T'));
        dao.adicionar(new Transacao("Julia", 30, "USD", 'D'));
        //Transacao.getLista().forEach(System.out::println);
        System.out.println("Saldo: " + dao.getSaldo("Caio"));

    }

    private static void simulatedAPIRequest() {
        System.out.println(CurrencyAPI.getQuote("BRL", "EUR"));
    }

    private static void yahooFinanceRequest() {
        var http = HttpClient.newHttpClient();
        try {
            var mapper = new JsonMapper()
                            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            var req = HttpRequest.newBuilder(new URI(ADDRESS)).GET().build();
            var resp = http.send(req, BodyHandlers.ofString());
            var yahooFinanceData = mapper.readValue(resp.body(), YahooFinanceData.class);
            var result = yahooFinanceData.getSpark().getResult()[0];
            System.out.println(result.getResponse()[0].getMeta().getRegularMarketPrice());
        } catch(URISyntaxException e) {
            System.err.println("Endereço da API inválido");
        } catch(IOException | InterruptedException e) {
            System.err.println("Ocorreu um erro ao enviar a requisição à API");
            e.printStackTrace();
        }
    }

}
