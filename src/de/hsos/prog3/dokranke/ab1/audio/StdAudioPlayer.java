package de.hsos.prog3.dokranke.ab1.audio;

import java.net.URL;

public interface StdAudioPlayer {

    void einmaligAbspielen(URL url);
    void wiederholtAbspielen(URL url, int wiederholungen);
    void tonAus();
    void tonAn();
}
