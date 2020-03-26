package de.hsos.prog3.dokranke.ab02.ui;

import de.hsos.prog3.dokranke.ab02.util.Interaktionsbrett;

public class QuadratTest {

    public static void main(String[] args) {
        Interaktionsbrett ib = new Interaktionsbrett();
        Quadrat q1 = new Quadrat(0, 0, 20);
        q1.darstellenRahmen(ib);
        Quadrat q2 = new Quadrat(20, 20, 20);
        q2.darstellenFuellung(ib);
    }
}
