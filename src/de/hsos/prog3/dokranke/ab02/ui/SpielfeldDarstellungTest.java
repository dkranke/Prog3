package de.hsos.prog3.dokranke.ab02.ui;

import de.hsos.prog3.dokranke.ab02.util.Interaktionsbrett;

public class SpielfeldDarstellungTest {

    public static void main(String[] args) {
        Interaktionsbrett ib = new Interaktionsbrett();
        SpielfeldDarstellung spielfeldDarstellung = new SpielfeldDarstellung(ib);
        boolean[][] spielfeld = new boolean[5][5];
        spielfeld[2][2] = true;
        spielfeldDarstellung.spielfeldDarstellen(spielfeld);
    }
}

// Domenik Kranke <domenik@kranke.de>