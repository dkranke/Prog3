package de.hsos.prog3.dokranke.ab02.ui;

import de.hsos.prog3.dokranke.ab02.logik.Simulator;

public class Main {

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        Steuerung steuerung = new Steuerung(simulator);
        steuerung.startDesSpiels();

        int anzahlDerSimulationsschritte;
        do {
            anzahlDerSimulationsschritte = steuerung.getNutzerEingabe().anzahlDerSimulationsschritte();
            simulator.berechneFolgeGeneration(anzahlDerSimulationsschritte);
        } while (anzahlDerSimulationsschritte != -1);

        System.exit(0);
    }
}
