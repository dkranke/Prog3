package de.hsos.prog3.dokranke.ab02.logik;

public class SimulatorTest {

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        simulator.anmeldenFuerAktualisierungBeiAenderung(neueGeneration -> {
            for (boolean[] row : neueGeneration) {
                for (boolean item : row) {
                    System.out.print(item ? " # " : " . ");
                }
                System.out.println();
            }
        });

        simulator.berechneAnfangsGeneration(10, 33);
        System.out.println();
        simulator.berechneFolgeGeneration(1);
        System.out.println();
        simulator.berechneFolgeGeneration(2);
    }
}
