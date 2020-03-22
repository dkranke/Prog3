package de.hsos.prog3.dokranke.ab1;

import java.util.HashSet;
import java.util.Optional;

public class App {

    public static void main(String[] args) {
        // Set ist wie List, nur ohne Duplikate
        HashSet<Nachbar> nachbarn = new HashSet<>();
        nachbarn.add(new Nachbar("Vorname1", "Nachname1"));
        nachbarn.add(new Nachbar("Vorname2", "Nachname2"));
        nachbarn.add(new Nachbar("Vorname3", "Nachname3"));
        nachbarn.add(new Nachbar("Vorname4", "Nachname4"));
        nachbarn.add(new Nachbar("Vorname1", "Nachname1"));

        // Ausgabe-Text generieren
        Optional<String> auflistung = nachbarn.stream()
                .map(Nachbar::toString)
                .reduce((string1, string2) -> string1 + ", " + string2);

        // Text Ausgeben (falls es etwas zum ausgeben gibt)
        auflistung.ifPresent(System.out::println);
    }
}

// Domenik Kranke <domenik@kranke.de>