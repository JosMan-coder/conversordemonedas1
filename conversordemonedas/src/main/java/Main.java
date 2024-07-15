package com.conversordemonedas;

import java.io.IOException;
import java.util.Scanner;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {
    private static final String API_KEY = "cc42805563db2dae001ecc4f";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("Menú de Conversión de Monedas:");
            System.out.println("1. Dólar a Peso Mexicano");
            System.out.println("2. Peso Mexicano a Dólar");
            System.out.println("3. Dólar a Peso Colombiano");
            System.out.println("4. Peso Colombiano a Dólar");
            System.out.println("5. Dólar a Real Brasileño");
            System.out.println("6. Real Brasileño a Dólar");
            System.out.println("7. Dólar a Peso Argentino");
            System.out.println("8. Peso Argentino a Dólar");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            if (option >= 1 && option <= 8) {
                handleConversion(option, scanner);
            }
        } while (option != 9);
        scanner.close();
    }

    private static void handleConversion(int option, Scanner scanner) {
        String fromCurrency = "";
        String toCurrency = "";
        switch (option) {
            case 1:
                fromCurrency = "USD";
                toCurrency = "MXN";
                break;
            case 2:
                fromCurrency = "MXN";
                toCurrency = "USD";
                break;
            case 3:
                fromCurrency = "USD";
                toCurrency = "COP";
                break;
            case 4:
                fromCurrency = "COP";
                toCurrency = "USD";
                break;
            case 5:
                fromCurrency = "USD";
                toCurrency = "BRL";
                break;
            case 6:
                fromCurrency = "BRL";
                toCurrency = "USD";
                break;
            case 7:
                fromCurrency = "USD";
                toCurrency = "ARS";
                break;
            case 8:
                fromCurrency = "ARS";
                toCurrency = "USD";
                break;
        }
        System.out.print("Ingrese el monto en " + fromCurrency + ": ");
        double amount = scanner.nextDouble();
        double result = convertCurrency(fromCurrency, toCurrency, amount);
        if (result != -1) {
            System.out.println("El monto en " + toCurrency + " es: " + result);
        } else {
            System.out.println("Error en la conversión.");
        }
    }

    private static double convertCurrency(String from, String to, double amount) {
        OkHttpClient client = new OkHttpClient();
        String url = BASE_URL + from + "/" + to;
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonResponse = response.body().string();
                System.out.println("Response JSON: " + jsonResponse);  // Añade esta línea para ver la respuesta
                JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
                double conversionRate = jsonObject.get("conversion_rate").getAsDouble();
                return amount * conversionRate;
            } else {
                System.out.println("Response was not successful: " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
