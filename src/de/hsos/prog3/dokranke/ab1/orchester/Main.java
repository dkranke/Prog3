package de.hsos.prog3.dokranke.ab1.orchester;

public class Main {

    public static void main(String[] args) {
        Orchester orchester = new Orchester("Test", "/All_Together.wav");

        orchester.addDirigentIn(new Dirigent("Dirigent"));

        orchester.addMusikerInnen(new MusikerIn("Akkordion Spieler 1", Instrument.AKKORDION));
        orchester.addMusikerInnen(new MusikerIn("Akkordion Spieler 2", Instrument.AKKORDION));
        orchester.addMusikerInnen(new MusikerIn("Saxophon Spieler", Instrument.SAXOPHON));
        orchester.addMusikerInnen(new MusikerIn("Saxophon Spieler", Instrument.SAXOPHON));
        orchester.addMusikerInnen(new MusikerIn("Schlagzeug Spieler", Instrument.SCHLAGZEUG));

        orchester.proben();
        orchester.spielen();

        orchester.auftreten();
        orchester.spielen();
    }
}
