package de.hsos.prog3.dokranke.ab02.ui;

import de.hsos.prog3.dokranke.ab02.util.Interaktionsbrett;

public class SpielfeldDarstellung {

    private static final int SEITENLAENGE = 30;
    private static final int MARGIN = 2;

    private Interaktionsbrett ib;

    public SpielfeldDarstellung(Interaktionsbrett ib) {
        this.ib = ib;
    }

    public void spielfeldDarstellen(boolean[][] spielfeld) {
        for (int y = 0; y < spielfeld.length; y++) {
            for (int x = 0; x < spielfeld[0].length; x++) {
                Quadrat q = new Quadrat(SEITENLAENGE * x + MARGIN, SEITENLAENGE * y + MARGIN, SEITENLAENGE);
                if (spielfeld[y][x]) {
                    q.darstellenFuellung(ib);
                } else {
                    q.darstellenRahmen(ib);
                }
            }
        }
    }

    public void abwischen() {
        ib.abwischen();
    }
}
