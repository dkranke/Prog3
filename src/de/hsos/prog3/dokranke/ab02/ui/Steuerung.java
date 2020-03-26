package de.hsos.prog3.dokranke.ab02.ui;

import de.hsos.prog3.dokranke.ab02.logik.BeiAenderung;
import de.hsos.prog3.dokranke.ab02.logik.Simulation;
import de.hsos.prog3.dokranke.ab02.util.EinUndAusgabe;
import de.hsos.prog3.dokranke.ab02.util.Interaktionsbrett;

public class Steuerung implements BeiAenderung {

    private NutzerEingabe nutzerEingabe;
    private SpielfeldDarstellung spielfeldDarstellung;
    private Simulation simulation;

    public Steuerung() {
        this.nutzerEingabe = new NutzerEingabe(new EinUndAusgabe());
        this.spielfeldDarstellung = new SpielfeldDarstellung(new Interaktionsbrett());
    }

    public void startDesSpiels() {

    }

    private void initialisierung() {

    }

    public void aktualisiere(boolean[][] neueGeneration) {

    }
}
