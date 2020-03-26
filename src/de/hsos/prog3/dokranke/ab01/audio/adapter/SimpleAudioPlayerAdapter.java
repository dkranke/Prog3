package de.hsos.prog3.dokranke.ab01.audio.adapter;

import de.hsos.prog3.audio.SimpleAudioPlayer;
import de.hsos.prog3.dokranke.ab01.audio.StdAudioPlayer;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class SimpleAudioPlayerAdapter implements StdAudioPlayer {

    private SimpleAudioPlayer wrappedPlayer;
    // Normalerweise ohne debug, aber setAudioFile und getDebug sind privat
    private boolean debug;

    public SimpleAudioPlayerAdapter(URL url) throws IOException {
        wrappedPlayer = new SimpleAudioPlayer(url);
        wrappedPlayer.getAudioFile();
        wrappedPlayer.setDebug(false);
        wrappedPlayer.verboseLogging(true);
    }

    @Override
    public void einmaligAbspielen(URL url) throws IOException {
        wiederholtAbspielen(url, 0);
    }

    @Override
    public void wiederholtAbspielen(URL url, int wiederholungen) throws IOException {
        Objects.requireNonNull(url);

        if (!wrappedPlayer.getAudioFile().equals(url)) {
            wrappedPlayer = new SimpleAudioPlayer(url);
            wrappedPlayer.getAudioFile();
            wrappedPlayer.setDebug(debug);
            wrappedPlayer.verboseLogging(true);
        }
        wrappedPlayer.play(0);
    }

    @Override
    public void tonAus() {
        wrappedPlayer.setDebug(true);
        debug = true;
    }

    @Override
    public void tonAn() {
        wrappedPlayer.setDebug(false);
        debug = false;
    }
}

// Domenik Kranke <domenik@kranke.de>
