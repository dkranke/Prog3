package de.hsos.prog3.dokranke.ab01.orchester;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class Orchester {

    private String bezeichnung;
    private String audioDateiKonzert;
    private Dirigent dirigentIn;
    private Collection<MusikerIn> musikerInnen;
    private Verhalten verhalten;

    public Orchester(String bezeichnung, String audioDateiKonzert) {
        Objects.requireNonNull(bezeichnung);
        Objects.requireNonNull(audioDateiKonzert);

        this.bezeichnung = bezeichnung;
        this.audioDateiKonzert = audioDateiKonzert;
        musikerInnen = new HashSet<>();
    }

    public void addDirigentIn(Dirigent dirigentIn) {
        this.dirigentIn = dirigentIn;
    }

    public void addMusikerInnen(MusikerIn musikerIn) {
        Objects.requireNonNull(musikerIn);
        
        musikerInnen.add(musikerIn);
    }

    public Collection<MusikerIn> getMusikerInnen() {
        return musikerInnen;
    }

    public void proben() {
        verhalten = new Konzert.Probe();
    }

    public void auftreten() {
        verhalten = new Konzert.Auftritt();
    }

    public void spielen() {
        verhalten.spielen(this);
    }

    public String getAudioDateiKonzert() {
        return audioDateiKonzert;
    }
}

// Domenik Kranke <domenik@kranke.de>