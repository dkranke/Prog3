package de.hsos.prog3.dokranke.ab02.logik;

public interface Simulation {

    void berechneAnfangsGeneration(int anzahlDerZeilen, int wahrscheinlichkeitDerBesiedelung);
    void berechneFolgeGeneration(int berechnungsschritte);
    void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung);
}

// Domenik Kranke <domenik@kranke.de>