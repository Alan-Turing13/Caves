package com.caves.levels;

import com.caves.Level;
import com.caves.Player;
import com.caves.TimedDecision1;
import com.caves.sounds.LongSound;
import com.caves.sounds.ShortSound;

import static java.lang.Integer.parseInt;
import static java.lang.System.out;

public class Serpent extends Level {

    LongSound w = new LongSound("WATER.wav");
    Thread water = new Thread(w);
    ShortSound z = new ShortSound("ZARA.wav");
    Thread zarathustra = new Thread(z);
    LongSound s = new LongSound("SERPENT.wav");
    Thread serpent = new Thread(s);
    ShortSound sp = new ShortSound("SPLASH.wav");
    Thread splash = new Thread(sp);
    LongSound d = new LongSound("DEATH.wav");
    Thread death = new Thread(d);

    ShortSound wh = new ShortSound("whip_sound.wav");
    Thread whip = new Thread(wh);
    ShortSound a1 = new ShortSound("arrow_one.wav");
    Thread arrow1 = new Thread(a1);
    ShortSound a2 = new ShortSound("arrow_two.wav");
    Thread arrow2 = new Thread(a2);
    ShortSound g = new ShortSound("fains.wav");
    Thread getGemshorn = new Thread(g);
    ShortSound ge = new ShortSound("GEMSHORN.wav");
    Thread gemshorn = new Thread(ge);

    public void getEaten(Player player){
        death.start();
        out.println("\u26A0 The Sea-Serpent Impales Your Abdomen On One Of Its Horribly Large Teeth,");
        out.println("Dragging You Down To The Bottom Of The Lake To Devour You In Poop-Scented Solitude. \u26A0");
        s.stopPlayback();
        w.stopPlayback();
        input.nextLine();
        d.stopPlayback();
    }

    public String play(Player player) {
        water.start();
        out.println("\nIt's darker than a black-hole down here.");
        input.nextLine();
        out.println("Damp too. There are probably bats and all other kind of nocturnal creatures.");
        input.nextLine();

        String banter = "";
        out.println("a) I miss my pet crocodile");
        out.println("b) This story lacks a strong female character");

        while (!banter.equals("a") && !banter.equals("b")) {
            banter = input.nextLine().toLowerCase();
        }

        if (banter.equals("a")) {
            out.println("\nI mean me too, but we all have to grow up some day");
        }
        if (banter.equals("b")) {
            out.println("\nDon't look at me, if there was a decent shopping centre she'd be here");
        }
        input.nextLine();

        out.println("You carefully slide over some rocks, following the sound of a river...");
        input.nextLine();
        zarathustra.start();
        out.println("You notice a small cedarwood boat with a Tall Blue-skinned Man inside looking contemplative.");
        input.nextLine();
        out.println("> 'e' for embark");
        out.println("> 'a' I have other arrangements.");
        String c1 = "";
        while (!c1.equals("e") && !c1.equals("a")) {
            c1 = input.nextLine().toLowerCase();
        }

        if (c1.equals("a")) {
            out.println("\nWhat with your busy schedule, you turn and head back.");
            input.nextLine();
            out.println("However, the next thing you know, you slip on one of the rocks nearly spraining your ankle.");
            input.nextLine();
            out.println("You stop to reconsider....");
            input.nextLine();
            out.println("...finally deciding to enter the boat instead.");
            input.nextLine();
        }

        Integer riddle = 0;
        Integer attempts = 0;
        out.println("\nZarathustra:");
        out.println("'On a piano, take the amount of black keys in an octave.");
        out.println("Then take the amount of white keys.'");
        input.nextLine();
        out.println("'What's the average of the two numbers?'");

        while (riddle != 6) {
            if (attempts == 3) {
                out.println("\n'I'll give you a clue.");
                out.println("The Antichrist / 111'.");
            }
            try {
                riddle = parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                ;
            }
            attempts++;
        }

        ShortSound z1 = new ShortSound("ZARA.wav");
        Thread zarathustra1 = new Thread(z1);
        zarathustra1.start();
        // explain how the number 6 relates to the 72 levels in the tower?
        if (attempts < 2) {
            out.println("\n'" + player.getName() + ". I see you're familiar with our world.'");
        }
        else if (attempts < 4) {
            out.println("\n'Good.'");
        }
        else if (attempts < 6) {
            out.println("\n'Try to work on your music theory a bit more.'");
        } else {
            out.println("\n'That was painful. But we got there in the end.'");
        }


        input.nextLine();
        out.println("\nYour turquoise friend rows you out into the inky midst of some vast subterranean lake.");
        input.nextLine();
        out.println("Down here the sun is a distant memory or, perhaps, a myth that died out.");
        input.nextLine();

        ShortSound z2 = new ShortSound("ZARA.wav");
        Thread zarathustra2 = new Thread(z2);
        zarathustra2.start();
        out.println("'When I do count the clock that tells the time");
        out.println("And see the brave day sunk in hideous night...'");
        out.println("he murmurs.");

        ShortSound z3 = new ShortSound("ZARA.wav");
        Thread zarathustra3 = new Thread(z3);
        zarathustra3.start();
        input.nextLine();
        out.println("You:");
        out.println("a) decide to order in some food");
        out.println("b) ease into the ambience of the cave");

        String c2 = input.nextLine().toLowerCase();
        if (c2.equals("a") && player.hasPhone()) {
            ShortSound e = new ShortSound("error.wav");
            Thread error = new Thread(e);
            error.start();
            out.println("\nYou have 0 bars of signal.");
            input.nextLine();
        }
        if (c2.equals("a") && !player.hasPhone()) {
            out.println("Your phone is cooked.");
            input.nextLine();
            out.println("It can't be turned on.");
            input.nextLine();
        }

        ShortSound z4 = new ShortSound("ZARA.wav");
        Thread zarathustra4 = new Thread(z4);
        zarathustra4.start();
        out.println("\nZarathustra: ");
        out.println("'A more fearsome beast than all of human appetite resides in these waters.'");
        input.nextLine();
        out.println("'To keep your life,");
        out.println("Be A Lamp In The Darkness.'");
        input.nextLine();

        serpent.start();
        out.println("Your Boat Is Knocked High Into The Air.");
        out.println("You Are Sent Flying And Unable To See.");
//        out.println("Has Time Finally Had A Stop");
        input.nextLine();
        out.println("‼️⏳");
        out.println("a) You Decide To Swim Yourself Back To Shore.");
        out.println("b) You Scream For Help.");
        out.println("c) You Turn On Your Phone Torch.\n");

        TimedDecision1 timedDecision1a = new TimedDecision1();
        boolean correctAnswer1a = timedDecision1a.decision("c");

        if (correctAnswer1a == false) {
            getEaten(player);
            return "dead";
        } else {
            if (!player.hasPhone()) {
                out.println("Your phone won't turn on.");
                input.nextLine();
                getEaten(player);
                return "dead";
            }
            out.println("AS YOU SHINE YOUR ELECTRONIC BEAM");
            out.println("INTO THE CREATURE'S HIDEOUS FACE");
            out.println("THE SEA-SERPENT <b666d b666666r> WAILS,");
            out.println("WRITHING ABOUT IN ANGRY CONFUSION.");
            input.nextLine();
            splash.start();
            out.println("You Splash Down Into The Water, Landing On The Horned Snake's Oily Neck.");
            input.nextLine();
            out.println("THE HORNED SERPENT TURNS TO CONSUME YOU");
            out.println("WITH A PIZZA-CRAZED LOOK IN HIS EYES!!");
            input.nextLine();

            out.println("‼️⏳");
            out.println("a) Play dead");
            if (player.hasCable()) {
                out.println("b) Use jack-cable");
            }
            else {out.println("b) Punch Serpent In Face");}
            out.println("c) Do a breathing exercises");

            TimedDecision1 timedDecision1c = new TimedDecision1();
            boolean correctAnswer1c;
            if (player.hasCable()) {
                correctAnswer1c = timedDecision1c.decision("b");
            }
            else {
                correctAnswer1c = timedDecision1c.decision("lack-o-cable");
            }
            if (correctAnswer1c == false) {
                getEaten(player);
                return "dead";
            } else
                s.stopPlayback();
                LongSound s2 = new LongSound("serpent2.wav");
                Thread serpent2 = new Thread(s2);
                serpent2.start();
                whip.start();

                out.println("\nYOU WHIP THE CABLE UNDERNEATH ITS JAW,");
                out.println("CATCHING THE OTHER END WITH YOUR OFF-HAND,");
                out.println("AND START TO PULL WITH ALL YOUR MIGHT.");
                input.nextLine();
                out.println("With A Quickness Reminiscent Of Allen Iverson circa 2002,");
                out.println("Zarathustra Darts In Front Of The Foul Creature.");
                input.nextLine();
                out.println("He Lands In The Boat And All In One Deft Movement");
                out.println("Arms Himself With A Wooden Bow.");
                arrow1.start();
                input.nextLine();
                arrow2.start();
                s2.stopPlayback();
                LongSound c = new LongSound("CABLE.wav");
                Thread cable = new Thread(c);
                cable.start();
                LongSound se = new LongSound("SERPENT.wav");
                Thread serpent3 = new Thread(se);
                serpent3.start();

                out.println("As He Fires An Arrow Straight Into Its Eye,");
                out.println("You Feel The Giant Beast Start To Suck You Down Into The Water...");
                input.nextLine();

                out.println("‼️⏳");
                out.println("a) Rip out arrow; get back into boat");
                out.println("b) Do to the dragon what Shaq did to the 76ers in the 2001 NBA finals");
                out.println("c) Swim for your life\n");

                TimedDecision1 timedDecision1b = new TimedDecision1();
                boolean correctAnswer1b = timedDecision1b.decision("a");

                if (correctAnswer1b == false) {
                    getEaten(player);
                    c.stopPlayback(); se.stopPlayback();
                    return "dead";
                } else {
                    ShortSound spl = new ShortSound("SPLASH.wav");
                    Thread splash2 = new Thread(spl);
                    splash2.start();
                    LongSound ad = new LongSound("ableDino.wav");
                    Thread albeDino = new Thread(ad);
                    albeDino.start();
                    se.stopPlayback();
                    c.stopPlayback();
                    out.println("Zarathustra: 'Get in!'");
                    input.nextLine();

                    out.println("In a cold-sweat, your arms numb and hands torn,");
                    out.println("you collapse into the boat.");
                    input.nextLine();

                    d.stopPlayback();
                    s.stopPlayback();
                    w.stopPlayback();
                    LongSound w2 = new LongSound("WATER.wav");
                    Thread water2 = new Thread(w2);
                    water2.start();
                    player.receiveGemshorn();
                    out.println("\nZarathustra rows 🛶");
                    input.nextLine();
                    out.println("You lie there panting, staring up at the Abyss.");
                    out.println("'Here, you've earnt this.'");
                    input.nextLine();
                    out.println("\nHe hands you an ocarina, nearly unbreakable, but not weighing too much.");
                    getGemshorn.start();
                    input.nextLine();
                    out.println("You squeeze the horn gently in your hand. It does feel like");
                    out.println("it was made in the centre of the earth.");
                    input.nextLine();
                    out.println("Zarathustra: 'You can use this to call a friend of mine.'");
                    input.nextLine();
                    out.println("'He is the one to take you from this place,");
                    out.println("and he's the one who can bring you back.'");

                    ShortSound gem2 = new ShortSound("fains.wav");
                    Thread gains2 = new Thread(gem2);
                    gains2.start();
                    input.nextLine();
                    out.println("\n'He can't pass through doors, his terrain is the sky.'");
                    input.nextLine();
                    out.println("Before you part ways, your blue-skinned companion instructs you on the ocarina.");
                    input.nextLine();
                    out.println("Zarathustra: 'Blow from your belly, not from your neck.");
                    out.println("Otherwise the sound won't project.'");
                    input.nextLine();
                    out.println("> Play ocarina");
                    input.nextLine();
                    ad.stopPlayback();
                    gemshorn.start();
                    out.println("💨");
                    input.nextLine();
                    out.println("'That's it.'");
                    input.nextLine();
                    out.println("'Be careful with that that arrow,");
                    out.println("it's one of Ὄσιρις's...");
                    out.println("sharp enough to pin 72 trees together.'");
                    input.nextLine();
                    out.println("You climb back over the rocks and re-enter the tower.");
                    input.nextLine();
                    w2.stopPlayback();
            }
        }
        return "staircase";
    }
}
