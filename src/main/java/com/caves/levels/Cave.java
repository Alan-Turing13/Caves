package com.caves.levels;

import com.caves.Level;
import com.caves.Player;
import com.caves.sounds.LongSound;
import com.caves.sounds.ShortSound;
import static java.lang.System.out;

public class Cave extends Level {

    LongSound f = new LongSound("FIRE.wav");
    Thread fire = new Thread(f);
    ShortSound s = new ShortSound("SMASH.wav");
    Thread smash = new Thread(s);
    ShortSound w = new ShortSound("waterfall.wav");
    Thread waterfall = new Thread(w);

    public String play(Player player){
        fire.start();
        out.println("\n* * * CAVES * * *");
        String cheat = "";
        cheat = input.nextLine();
        if (cheat.equals("c")) {f.stopPlayback(); player.receiveCable(); player.setName("Duckboy"); return "cheat";}
        out.println("You're in a tall fire-lit cavern with two pathways at the back.");
        out.println("Do you go down the one on the left or the one on the right?\n");

        // wait until the player answers
        while (true) {

            String firstRoom = "\nYou walk around the cave. It's ever so slightly damp," +
                    " with warm red clay walls.\n";

            out.println("> 'l' for left");
            out.println("> 'r' for right");
            String c1 = input.nextLine().toLowerCase();

            // left
            if (c1.equals("l")) {
                out.println("\nA tiny orange crocodile scurries and hurries across the floor.");
                if (player.sandwiches >= 0) {out.println("Do you follow this excitable critter, or dine on some sandwiches.\n");}
                else out.println("In the absence of any more sandwiches, do you follow this excitable critter?\n");

                String c2Left = "";

                // no phone
                if (!player.hasPhone()) {
                    out.println("> 'f' for follow");
                    out.println("> 'r' for retreat");
                    if (player.sandwiches >= 0) {
                        out.println("> 's' for sandwich");
                    }
                }

                // phone
                else {
                    out.println("> 'f' for follow");
                    out.println("> 'b' for browse t6666k");
                    if (player.sandwiches >= 0) {
                        out.println("> 's' for sandwich");
                    }
                }

                while (!c2Left.equals("f") && !c2Left.equals("r") && !c2Left.equals("s") && !c2Left.equals("b")) {
                    c2Left = input.nextLine().toLowerCase();
                }

                // follow
                if (c2Left.equals("f")) {
                    out.println("\nYou come to a waterfall. Your lizard accomplice jumps down there.");
                    out.println("Do you follow suit?");
                    out.println("> y");
                    out.println("> n");

                    // jump
                    String c3Follow = input.nextLine().toLowerCase();
                    if (c3Follow.equals("y")) {
                        f.stopPlayback();
                        waterfall.start();
                        return "below";
                    }
                    // do not jump
                    else {out.println(firstRoom); continue;}
                }

                // tiktok
                else if (c2Left.equals("b")) {
                    player.breakPhone();
                    out.println("\nThe t6666k dancer is way off.");
                    out.println("You decide to put your phone away immediately");
                    out.println("to rescue the most precious partner of all own, your own attention,");
                    out.println("but in doing so miss your pocket.");
                    input.nextLine();
                    new Thread(smash).start();
                    out.println("You break your phone on the hard rocky floor.");
                    input.nextLine();
                    continue;
                }

                // sandwiches
                else if (c2Left.equals("s") & player.sandwiches != 0) {
                    out.println("\nMmmmm. It was a good idea to bring these sandwiches.");
                    input.nextLine();
                    out.println("Shame there wasn't much marmite, but you can't");
                    out.println("have it all in life.");
                    player.sandwiches -= 1;
                    input.nextLine();
                    continue;
                }

                // lack of sandwiches
                else if (c2Left.equals("s")) {
                    out.println("\nNo sandwiches are left. Note to self:");
                    out.println("next time bring an apple.\n");
                    player.sandwiches -= 1;
                }

                // don't follow
                else {
                    out.println(firstRoom);
                    continue;
                }
            }

            // right
            if (c1.equals("r")) {
                out.println("\nIt leads outside to a snowy path leading up and around the mountain.");
                out.println("> 'a' - ascend");
                out.println("> 'g' - go back");

                String c2Right = input.nextLine().toLowerCase();

                if (c2Right.equals("a")) {
                    f.stopPlayback();
                    return "outside";
                } else {
                    out.println(firstRoom);
                }
            }
        }
    }
}
