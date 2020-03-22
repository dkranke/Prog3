package de.hsos.prog3.dokranke.ab1.audio.adapter;

import de.hsos.prog3.audio.SimpleAudioPlayer;
import de.hsos.prog3.dokranke.ab1.audio.StdAudioPlayer;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class SimpleAudioPlayerAdapter implements StdAudioPlayer {

    private boolean debug;
    // Normalerweise mit wrappedPlayer statt debug, aber setAudioFile ist privat
    //private SimpleAudioPlayer wrappedPlayer;

    @Override
    public void einmaligAbspielen(URL url) throws IOException {
        wiederholtAbspielen(url, 0);
    }

    @Override
    public void wiederholtAbspielen(URL url, int wiederholungen) throws IOException {
        Objects.requireNonNull(url);

        SimpleAudioPlayer player = new SimpleAudioPlayer(url);
        player.setDebug(debug);
        player.verboseLogging(true);
        player.play(0);
    }

    @Override
    public void tonAus() {
        debug = true;
    }

    @Override
    public void tonAn() {
        debug = false;
    }
}

// Domenik Kranke <domenik@kranke.de>
