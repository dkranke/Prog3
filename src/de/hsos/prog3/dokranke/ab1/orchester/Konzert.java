package de.hsos.prog3.dokranke.ab1.orchester;

import de.hsos.prog3.dokranke.ab1.audio.StdAudioPlayer;
import de.hsos.prog3.dokranke.ab1.audio.adapter.SimpleAudioPlayerAdapter;

import java.net.URL;

public class Konzert {

    // Konzert in Konzert macht keinen Sinn
    public static class Auftritt implements Verhalten {

        @Override
        public void spielen(Orchester orchester) {
            // Hier sollte etwas fehlschlagen können, aber StdAudioPlayer ist nicht so definiert
            StdAudioPlayer player = new SimpleAudioPlayerAdapter();
            player.tonAn();
            URL url = Orchester.class.getResource(orchester.getAudioDateiKonzert());
            player.einmaligAbspielen(url);
        }
    }

    public static class Probe implements Verhalten {

        @Override
        public void spielen(Orchester orchester) {
            // Hier sollte etwas fehlschlagen können, aber StdAudioPlayer ist nicht so definiert
            orchester.getMusikerInnen().forEach(musikerIn -> {
                StdAudioPlayer player = new SimpleAudioPlayerAdapter();
                player.tonAn();
                URL url = Probe.class.getResource(musikerIn.getInstrument().getAudiodatei());
                player.einmaligAbspielen(url);
            });
        }
    }
}
