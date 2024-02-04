package com.caves.levels;

import com.caves.Level;
import com.caves.Player;
import com.caves.sounds.LongSound;
import static java.lang.System.out;

public class Below extends Level {

    LongSound o = new LongSound("osiris.wav");
    Thread osiris = new Thread(o);
    LongSound y = new LongSound("YIKES.wav");
    Thread yikes = new Thread(y);
    LongSound c = new LongSound("CABLE.wav");
    Thread cable = new Thread(c);
    LongSound f = new LongSound("FIRE.wav");
    Thread fire = new Thread(f);

    public String play(Player player) {
        out.println("\nThe cool clear water carries you down to a rocky platform below.");
        input.nextLine();
        osiris.start();
        out.println("There's a chamber down here. You notice its inhabitant,");
        out.println("Ὄσιρις, The Undying Sun-God Of Fertility.");
        input.nextLine();
        out.println("You wonder how you know who it is... ");
        input.nextLine();
        out.println("Oh yeah, it's because He's made out of sound.");
        input.nextLine();
        out.println("Ὄσιρις doesn't communicate with speech.\n");
        out.println("As easily as you can sip a glass of water, He can transmit a whole book into your memory.");
        input.nextLine();
        out.println("Do you find it unsettling that Ὄσιρις knows your whole past, present and future");
        out.println("and could fit it all on one page without missing any details?\n");

        out.println("> 's' for scared ಠ_ಠ");
        out.println("> 'n' for no not really, I know lots of people who can do that.");
        input.nextLine();

        yikes.start();
        out.println("\nὌσιρις: 'The Great Dragon Was Hurled Down,");
        out.println("That Ancient Serpent Called <B666D B666666R>");
        out.println("Who Leads The Whole World Astray.");
        out.println("He Was Hurled To The Earth, And His Retinue With Him.'");
        input.nextLine();
        String c2 = "";
        while (!c2.equals("i") && !c2.equals("l") && !c2.equals("s")) {
            out.println("> 'i' for ignore");
            out.println("> 'l' for look contemptuous");
            out.println("> 's' for say a short prayer");
            c2 = input.nextLine().toLowerCase();
        }

        // Say A Little Prayer
        if (c2.equals("s")) {
            cable.start();
            player.receiveCable();
            out.println("\n...");
            input.nextLine();
            out.println("Ὄσιρις: 'You Have A Name Written On You");
            out.println("That No-one Knows But You Yourself.'\n");

            String playerName = "";
            while (playerName.length() == 0) {
                out.println("> [type your name:] ");
                playerName = input.nextLine();
            }

            player.setName(playerName);

            o.stopPlayback();
            y.stopPlayback();
            c.stopPlayback();
            fire.start();

            out.println("\nIt feels like a few days have passed.");
            input.nextLine();
            out.println("The Lord of Silence gifts you a 10-metre jack cable made out of pure gold.");
            input.nextLine();
            out.println("Ὄσιρις: ");
            out.println("'" + playerName + ", Go Down.'");
            out.println("\n'Seize The Dragon, That Ancient Serpent, Who Is <B666D B666666R>,");
            out.println("And Bind Him For A Thousand Years. Throw Him Into The Abyss,'");
            input.nextLine();
            out.println("'And Lock And Seal It Over Him, To Keep Him From Deceiving The People Anymore");
            out.println("Until The Thousand Years Are Ended.'");
            input.nextLine();

            String newAnswer = "";
            out.println("> 'i' for i'll try");
            out.println("> 't' for thanks for the new cable, (though it is a bit long for most situations).");
            while (!newAnswer.equals("i") && !newAnswer.equals("t")) {
                newAnswer = input.nextLine();
            }
            out.println("\nProceed?");
            input.nextLine();
            f.stopPlayback();
            return "depths";
        }

        // Do not Meditate
        else out.println("\nIn a somewhat shifty manner, you sneak past.");
        input.nextLine();
        player.setName("Contemptuous III");
        o.stopPlayback();
        y.stopPlayback();
        return "depths";
    }
}
