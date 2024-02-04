package com.caves.sounds;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;

public class LongSound extends Sound implements Runnable {

    public LongSound(String filename){
        super(filename);
    }

    public final int BUFFER_SIZE = 4096;

    private volatile boolean stopped;

    public void stopPlayback() {this.stopped = true;}

    public void run() {
        try {
            AudioFormat af;
            DataLine.Info info;
            SourceDataLine sdl;

            while (!stopped) {
                super.inStr = getClass().getClassLoader().getResourceAsStream(super.file);
                super.buInStr = new BufferedInputStream(super.inStr);
                super.auStr = AudioSystem.getAudioInputStream(super.buInStr);
                af = super.auStr.getFormat();
                info = new DataLine.Info(SourceDataLine.class, af);
                sdl = (SourceDataLine) AudioSystem.getLine(info);
                sdl.open(af);
                sdl.start();

                byte[] bufferBytes = new byte[BUFFER_SIZE];
                int readBytes;

                while ((readBytes = super.auStr.read(bufferBytes)) != -1) {
                    sdl.write(bufferBytes, 0, readBytes);
                    if (stopped) {break;}
                }
                sdl.drain();
                sdl.close();
                super.auStr.close();
            }

        } catch (LineUnavailableException|UnsupportedAudioFileException| IOException e) {
            e.printStackTrace();
        }
    }
}
