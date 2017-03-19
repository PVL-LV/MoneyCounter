package ua.pvl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileParser {

    public Map<String, Double> parseAndCleanList(List<String> listOnePersonsMoney, String currencyType) {

        Map<String, Double> mp = new HashMap<>();

        double amountOfMoney = 0.00;
        String name = null;

        for (String str : listOnePersonsMoney) {
            if (isANameLine(str)) {
                name = str;
            } else {
                if (isAMoneyLine(str)){
                   double money = getAndConvertCurrency(str, currencyType);
                   amountOfMoney += money;
                }
            }
        }
        mp.put(name, amountOfMoney);
        return mp;
    }

    private double getAndConvertCurrency(String str, String currencyType) {

        double convertedMoney;

        String[] parts = str.split("=");
        String part2 = parts[1];

        String mn = part2.substring(1);
        double money = Double.parseDouble(mn);

        String cr = part2.substring(0, 1);

        if (cr == currencyType) {
            convertedMoney = money;
        } else {
            CurrencyConverter cc = new CurrencyConverter();
            convertedMoney = cc.convertMoney(money, currencyType, cr);
        }
        return convertedMoney;
    }

    public static boolean isANameLine(String str) {
        boolean bool = false;
        str = str.trim();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '=' && str.charAt(i) != '-') {
                bool = false;
                break;
            } else {
                bool = true;
            }
        }
        return bool;
    }

    public static boolean isAMoneyLine(String str) {

        boolean bool = false;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '=' &&  str.charAt(++i) != '-') {
                bool = true;
                break;
            }
        }
        return bool;
    }

    public static boolean isEndOfPersonMoneyLine(String str) {

        boolean bool = false;
        for(int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) == '-' &&  str.charAt(++i) == '-') {
                bool = true;
                break;
            }
        }
        return bool;
    }
}
