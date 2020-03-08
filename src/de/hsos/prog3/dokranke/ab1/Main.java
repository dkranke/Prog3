package de.hsos.prog3.dokranke.ab1;

import de.hsos.prog3.audio.SimpleAudioPlayer;
import de.hsos.prog3.dokranke.ab1.audio.StdAudioPlayer;
import de.hsos.prog3.dokranke.ab1.audio.adapter.SimpleAudioPlayerAdapter;

import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        URL url = Main.class.getResource("/Baritone.wav");
        StdAudioPlayer adapter = new SimpleAudioPlayerAdapter();
        adapter.tonAn();
        adapter.einmaligAbspielen(url);
    }
}
