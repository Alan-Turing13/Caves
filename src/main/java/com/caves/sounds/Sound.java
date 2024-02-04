package com.caves.sounds;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class Sound {

    // Sound takes the name of an audio file and creates three objects out of it.

    protected String file;
    protected InputStream inStr = null;
    protected BufferedInputStream buInStr = null;
    protected AudioInputStream auStr = null;
    protected AudioFormat auFor = null;

    public Sound(String filename) {
        try {
            this.file = filename;
            inStr = getClass().getClassLoader().getResourceAsStream(filename);
            buInStr = new BufferedInputStream(inStr);
            auStr = AudioSystem.getAudioInputStream(buInStr);
            auFor = auStr.getFormat();
        } catch (UnsupportedAudioFileException| IOException e) {
            e.printStackTrace();
        }
}
}
