package ua.pvl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileParser {


    Map<String, Double> mp = new HashMap<>();

    public void parseAndCleanList(List<String> listOnePersonsMoney, String currencyType) {

        for (String str : listOnePersonsMoney) {
            if (isANameLine(str)) {
                mp.put(str, 0.00);
            } else {
                if (isAMoneyLine(str)){
                   double money = findAmountAndConvert(str, currencyType);

                }
            }
        }

    }



    private double findAmountAndConvert(String str, String currencyType) {
        double money = 0.00;
        //parse str, get money and currence, convert if needed

        return money;
    }

    public static boolean isANameLine(String str) {
        boolean bool = false;
        str = str.trim();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != '=' || str.charAt(i) != '-') {
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
            }
        }
        return bool;
    }

    public static boolean isEndOfPersonMoneyLine(String str) {

        boolean bool = false;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '-' &&  str.charAt(++i) == '-') {
                bool = true;
            }
        }
        return bool;
    }




}
