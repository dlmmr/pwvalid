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
        if (password == null || password.isEmpty()) return false;

        boolean hasUpper = false;
        boolean hasLower = false;

        for (char c : password.toCharArray()) {
            if (c >= 'A' && c <= 'Z') hasUpper = true;
            else if (c >= 'a' && c <= 'z') hasLower = true;


            if (hasUpper && hasLower) return true; // Früh abbrechen, sobald beide gefunden
        }
        return false; // Wenn nur Upper oder nur Lower vorhanden ist → false
    }

    public static boolean containsSpecialChar(String password, String allowed) {
        allowed = "!@#$%^&*()-_+=?.,;:";
        for (char c : password.toCharArray()) {
            if (allowed.indexOf(c) >= 0) return true;
        }
        return false;
    }

    public static boolean hasMinGroups(String password, int requiredGroups) {
        return false;
    }

    public static boolean isCommonPassword(String password) {
        return false;
    }
}
