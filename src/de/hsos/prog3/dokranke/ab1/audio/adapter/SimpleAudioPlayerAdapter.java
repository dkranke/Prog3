package de.hsos.prog3.dokranke.ab1.audio.adapter;

import de.hsos.prog3.audio.SimpleAudioPlayer;
import de.hsos.prog3.dokranke.ab1.audio.StdAudioPlayer;

import java.io.IOException;
import java.net.URL;

public class SimpleAudioPlayerAdapter implements StdAudioPlayer {

    private boolean debug;
    // Normalerweise mit wrappedPlayer statt debug, aber setAudioFile ist privat
    //private SimpleAudioPlayer wrappedPlayer;

    @Override
    public void einmaligAbspielen(URL url) {
        wiederholtAbspielen(url, 0);
    }

    @Override
    public void wiederholtAbspielen(URL url, int wiederholungen) {
        try {
            SimpleAudioPlayer player = new SimpleAudioPlayer(url);
            player.setDebug(debug);
            player.verboseLogging(true);
            player.play(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
