package com.caves.sounds;

import javax.sound.sampled.*;
import java.io.IOException;

public class ShortSound extends Sound implements LineListener, Runnable {

    public ShortSound(String filename) {
        super(filename);
    }

    private boolean finished;

    // ascertain whether the audio file has finished playing
    @Override
    public void update(LineEvent ev){
        if (LineEvent.Type.STOP == ev.getType()) {
            finished = true;
        }
    }

    public void run() {
        try {
            DataLine.Info info = new DataLine.Info(Clip.class, super.auFor);
            Clip auClip = (Clip) AudioSystem.getLine(info);
            auClip.addLineListener(this);
            auClip.open(auStr);
            auClip.start();

            // keep on playing until the audio file is finished
            while (!finished) {
                    Thread.sleep(1000);
            }

            auClip.close();
            auStr.close();

        } catch (LineUnavailableException| IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
