package ua.pvl;

import java.util.*;

public class CurrencyConverter {

    Map<String, Double> currencies = new HashMap<>();

    public CurrencyConverter() {
        currencies.put("$", 1.0);
        currencies.put("£", 1.20);
        currencies.put("€", 0.93);
        currencies.put("₴", 26.76);
    }



    public double convertMoney(double money, String currencyType, String cr) {

        double rateToDollars = currencies.get(cr) ; // find the rate from source to dollars (may be 1.0).
        double rateToTarget = currencies.get(currencyType); // find the rate from target to dollars (may be 1.0)

        double targetAmount = (money / rateToDollars) * rateToTarget;

        return targetAmount;
    }



}
