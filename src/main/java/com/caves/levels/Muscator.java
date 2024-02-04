package com.caves.levels;

import com.caves.Level;
import com.caves.Player;
import com.caves.sounds.LongSound;
import com.caves.sounds.ShortSound;

import static java.lang.System.out;

public class Muscator extends Level {

    LongSound s = new LongSound("STEAMBUN.wav");
    Thread steambun = new Thread(s);
    ShortSound th = new ShortSound("thud2.wav");
    Thread thud = new Thread(th);

    public String play(Player player) {
        out.println("Unfazed by the wind - or for that matter by anything at all -");
        out.println("that majestic creature is flying straight for you.");
        steambun.start();
        thud.start();
        input.nextLine();
        out.println("You register a thud as you land on the dragon's back.");
        input.nextLine();
        out.println("As you soar together for 888 miles, you wonder if you'll be friends for life.");
        input.nextLine();
        out.println("(∵)");
        input.nextLine();
        out.println("The End");
        out.println("© Dominic J Marshall 2024");
        input.nextLine();
        return "";
    }

}
