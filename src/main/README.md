# pwvalid

Java-Bibliothek zur Validierung von Passwörtern.  
Sie prüft Passwörter anhand definierter Sicherheitsregeln.

## Kriterien

Ein gültiges Passwort erfüllt alle folgenden Bedingungen:

- Nicht `null` und nicht leer (`isBlank`)
- Mindestens 8 Zeichen Länge
- Mindestens eine Ziffer (`0–9`)
- Groß- und Kleinbuchstaben (beides muss vorkommen)
- Mindestens ein Sonderzeichen aus einer definierten Menge (z. B. `!@#$%^&*()-_=+`)
- Zeichen aus mindestens 3 von 4 Zeichengruppen: Großbuchstaben, Kleinbuchstaben, Ziffern, Sonderzeichen
- Darf nicht in einer internen Liste häufiger/schwacher Passwörter vorkommen

## API-Design

```java
public final class PasswordValidator {

    // Basisfunktionen
    public static boolean isNull(String password);
    public static boolean isBlank(String password);
    public static boolean hasMinLength(String password, int min);
    public static boolean containsDigit(String password);
    public static boolean containsUpperAndLower(String password);
    public static boolean containsSpecialChar(String password, String allowed);
    public static boolean hasMinGroups(String password, int requiredGroups);
    public static boolean isCommonPassword(String password);

    // Gesamtsicht
    public static boolean isValid(String password); // prüft alle Kriterien
}
