package de.hsos.prog3.dokranke.ab01;

import de.hsos.prog3.dokranke.ab01.audio.StdAudioPlayer;
import de.hsos.prog3.dokranke.ab01.audio.adapter.SimpleAudioPlayerAdapter;

import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
        URL url = Main.class.getResource("/Baritone.wav");
        StdAudioPlayer adapter = new SimpleAudioPlayerAdapter(url);
        adapter.tonAn();
        adapter.einmaligAbspielen(url);
    }
}

// Domenik Kranke <domenik@kranke.de>