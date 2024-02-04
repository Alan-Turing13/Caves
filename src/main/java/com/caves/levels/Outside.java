package com.caves.levels;

import com.caves.Level;
import com.caves.Player;
import com.caves.TimedDecision2;
import com.caves.sounds.LongSound;
import com.caves.sounds.ShortSound;
import static java.lang.System.out;

public class Outside extends Level {

    LongSound o = new LongSound("OUTSIDE.wav");
    Thread outside = new Thread(o);
    LongSound w = new LongSound("WIND.wav");
    Thread wind = new Thread(w);
    ShortSound th = new ShortSound("thud2.wav");
    Thread thud = new Thread(th);
    ShortSound g = new ShortSound("GEMSHORN.wav");
    Thread gemshorn = new Thread(g);

    String blizzard = "\nA POWERFUL BLIZZARD SUCKS YOU TO THE CLIFF-EDGE.";
    String deathByFalling = "You Fall 8,888 Metres To The Deathly Rocks Below. NOOOOOOOOOOO‼️";

    public String play(Player player) {
        outside.start();
        out.println("\nIt's cold outside & so windy you can barely move, but you can see mountains and hills for miles around.");
        input.nextLine();
        out.println("You've never seen a view like this before. It's somewhat overwhelming.");
        input.nextLine();

        // No gemshorn
        if (!player.hasGemshorn()) {
            out.println("> 'k' for keep walking");
            out.println("> 's' for stop to gaze out");
            input.nextLine();
            wind.start();
            out.println(blizzard);
            input.nextLine();
            out.println(deathByFalling);
            thud.start();
            try {thud.join();} catch (InterruptedException e) {;}
            w.stopPlayback();
            o.stopPlayback();
            return "dead";
        }

        // Gemshorn
        else {
            out.println("'Mountains silvered o\'er with white");
            out.println("and lofty trees shaking in the snow-drift, barren of leaves.'");
            input.nextLine();
            out.println("It's so windy you can barely move.\n");
            out.println("> 'g' for good to be out");
            out.println("> 'w' for where am I?");
            input.nextLine();

            // BLIZZARD
            wind.start();
            out.println(blizzard);
            out.println("\nWhat do you do? ⏳");

            final String[] answer1stHalf = new String[]{"play", "toot", "blow", "try"};
            final String[] answer2ndHalf = new String[]{"ocarina", "gemshorn", "horn", "instrument"};
            TimedDecision2 timedDecision = new TimedDecision2(answer1stHalf, answer2ndHalf);

            if (timedDecision.decision() == true){
                w.stopPlayback();
                gemshorn.start();
                out.println("...");
                input.nextLine();
                out.println("Out of the corner of your eye you spy an unidentified purple flying organism (UPFO).");
                o.stopPlayback();
                input.nextLine();
            }

            else {
                out.println(deathByFalling);
                thud.start();
                try {thud.join();} catch (InterruptedException e) {;}
                o.stopPlayback();
                w.stopPlayback();
                return "dead";
            }
        }
        return "muscator";
    }
}
