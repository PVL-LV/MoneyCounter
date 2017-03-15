package ua.pvl;

public class FileParser {

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
