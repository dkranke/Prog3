package de.hsos.prog3.dokranke.ab1.orchester;

import de.hsos.prog3.dokranke.ab1.audio.StdAudioPlayer;
import de.hsos.prog3.dokranke.ab1.audio.adapter.SimpleAudioPlayerAdapter;

import java.net.URL;

public class Probe implements Verhalten {

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
