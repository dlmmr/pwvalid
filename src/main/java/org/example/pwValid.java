package org.example;

public class pwValid {
    public static void main(String[] args) {

    }

    public static boolean isNull(String password) {
        return password == null;
    }

    public static boolean isBlank(String password) {
        if (password == null) return true;
        if (password.trim().length() == 0) return true;
        return false;
    }

    public static boolean hasMinLength(String password, int min) {
        if (password.length() >= min) return true;
        return false;
    }

    public static boolean containsDigit(String password) {
        int count = 0; // zählt gefundene Ziffern

        for (char c : password.toCharArray()) {
            if (c >= '0' && c <= '9') { //umgehen der Unicode falle in dem wir den Zahlenbereich genau eingrenzen
                count++;  //Zähler wird erhöht wenn ein c dem eingegebenen Zahlenbereich entspricht
            }
        }
        return count > 0; // true, wenn mindestens eine Ziffer gefunden, kein Unterschied ob mehrere oder nicht
    }


    public static boolean containsUpperAndLower(String password) {
        return false;
    }

    public static boolean containsSpecialChar(String password, String allowed) {
        return false;
    }

    public static boolean hasMinGroups(String password, int requiredGroups) {
        return false;
    }

    public static boolean isCommonPassword(String password) {
        return false;
    }
}
