package de.hsos.prog3.dokranke.ab1.orchester;

import de.hsos.prog3.dokranke.ab1.audio.StdAudioPlayer;
import de.hsos.prog3.dokranke.ab1.audio.adapter.SimpleAudioPlayerAdapter;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Konzert {

    // Konzert in Konzert macht keinen Sinn
    public static class Auftritt implements Verhalten {

        @Override
        public void spielen(Orchester orchester) {
            Objects.requireNonNull(orchester);

            try {
                URL url = Orchester.class.getResource(orchester.getAudioDateiKonzert());
                StdAudioPlayer player = new SimpleAudioPlayerAdapter(url);
                player.tonAn();
                player.einmaligAbspielen(url);
            } catch (IOException e) {
                System.out.println("Auftritt wird abgebrochen");
            }
        }
    }

    public static class Probe implements Verhalten {

        @Override
        public void spielen(Orchester orchester) {
            Objects.requireNonNull(orchester);

            try {
                for (MusikerIn musikerIn : orchester.getMusikerInnen()) {
                    URL url = Probe.class.getResource(musikerIn.getInstrument().getAudiodatei());
                    StdAudioPlayer player = new SimpleAudioPlayerAdapter(url);
                    player.tonAn();
                    player.einmaligAbspielen(url);
                }
            } catch (IOException e) {
                System.out.println("Auftritt wird abgebrochen");
            }
        }
    }
}

// Domenik Kranke <domenik@kranke.de>