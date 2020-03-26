package de.hsos.prog3.dokranke.ab02.ui;

import de.hsos.prog3.dokranke.ab02.logik.BeiAenderung;
import de.hsos.prog3.dokranke.ab02.logik.Simulation;
import de.hsos.prog3.dokranke.ab02.logik.Simulator;
import de.hsos.prog3.dokranke.ab02.util.EinUndAusgabe;
import de.hsos.prog3.dokranke.ab02.util.Interaktionsbrett;

import java.util.Objects;

public class Steuerung implements BeiAenderung {

    private NutzerEingabe nutzerEingabe;
    private SpielfeldDarstellung spielfeldDarstellung;
    private Simulation simulation;

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        Steuerung steuerung = new Steuerung(simulator);
        steuerung.initialisierung();
        steuerung.startDesSpiels();

        int anzahlDerSimulationsschritte;
        do {
            anzahlDerSimulationsschritte = steuerung.nutzerEingabe.anzahlDerSimulationsschritte();
            simulator.berechneFolgeGeneration(anzahlDerSimulationsschritte);
        } while (anzahlDerSimulationsschritte != -1);

        System.exit(0);
    }

    public Steuerung(Simulation simulation) {
        Objects.requireNonNull(simulation);

        this.simulation = simulation;
    }

    public void startDesSpiels() {
        int anzahlZeilenDesSpielfelds = nutzerEingabe.anzahlZeilenDesSpielfelds();
        int wahrscheinlichkeitDerBesiedlung = nutzerEingabe.wahrscheinlichkeitDerBesiedlung();
        simulation.berechneAnfangsGeneration(anzahlZeilenDesSpielfelds, wahrscheinlichkeitDerBesiedlung);
    }

    private void initialisierung() {
        EinUndAusgabe einUndAusgabe = new EinUndAusgabe();
        nutzerEingabe = new NutzerEingabe(einUndAusgabe);

        Interaktionsbrett interaktionsbrett = new Interaktionsbrett();
        spielfeldDarstellung = new SpielfeldDarstellung(interaktionsbrett);

        simulation.anmeldenFuerAktualisierungBeiAenderung(this);
    }

    public void aktualisiere(boolean[][] neueGeneration) {
        spielfeldDarstellung.abwischen();
        spielfeldDarstellung.spielfeldDarstellen(neueGeneration);
    }
}

// Domenik Kranke <domenik@kranke.de>