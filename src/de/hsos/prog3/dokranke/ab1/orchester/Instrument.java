package de.hsos.prog3.dokranke.ab1.orchester;

public enum Instrument {

    SAXOPHON("/Baritone.wav"), SCHLAGZEUG("/Drum.wav"), AKKORDION("/Accordion.wav");

    private String audiodatei;

    Instrument(String audiodatei) {
        this.audiodatei = audiodatei;
    }

    public String getAudiodatei() {
        return audiodatei;
    }
}

// Domenik Kranke <domenik@kranke.de>