package com.caves.levels;

import com.caves.Level;
import com.caves.Player;
import com.caves.TimedDecision3;
import com.caves.sounds.LongSound;
import com.caves.sounds.ShortSound;

import static java.lang.System.out;

public class Staircase extends Level {

    LongSound d = new LongSound("DEPTHS.wav");
    Thread depths = new Thread(d);
    LongSound t = new LongSound("TAURUS.wav");
    Thread taurus = new Thread(t);
    LongSound m = new LongSound("mournful.wav");
    Thread mournful = new Thread(m);
    LongSound t2 = new LongSound("taurus 2.wav");
    Thread taurus2 = new Thread(t2);
    LongSound mi = new LongSound("minotaur.wav");
    Thread mino = new Thread(mi);
    LongSound ta = new LongSound("TAURUS.wav");
    Thread tau2 = new Thread(ta);
    LongSound de = new LongSound("DEATH.wav");
    Thread death = new Thread(de);

    public void minoDeath(Player player) {

        t2.stopPlayback(); m.stopPlayback();
        tau2.start();

        out.println("\nThe Minotaur Charges At You");
        out.println("Smashing Its Horns Into Your Ribcage.");
        input.nextLine();
        death.start();
        out.println("It Throws You Off The Spiral Staircase");
        out.println("Down To The Bottom Of The Tower,");
        out.println("To Your Doom.\n");
        input.nextLine();
        ta.stopPlayback(); de.stopPlayback(); mi.stopPlayback(); t.stopPlayback(); d.stopPlayback();
    }

    public String minotaur(Player player) {
        out.println("You notice a dark horned figure lurking on the stairs.");
        mino.start();
        input.nextLine();
        out.println("He's making a low murmuring gruntish sound.");
        input.nextLine();
        out.println("You: ");
        out.println("a) Tiptoe up with stealth");
        out.println("b) Saunter up all casual");
        input.nextLine();
        taurus.start();
        out.println("\n:The Taurus Demon Puts His Head Down And Starts Thundering Towards You.:");
        input.nextLine();
        out.println("‼️⏳");
        if (player.hasGemshorn()) {
            out.println("a) Wait To Get Close, Then Attack With Arrow");
        }
        else {
            out.println("a) Dodge His Attack");
        }
        out.println("b) Offer Him A Sandwich");
        out.println("c) Curl Up In Ball");

        TimedDecision3 timedDecision3 = new TimedDecision3();
        String outcome = timedDecision3.decision("b");

        if (outcome.equals("wrong-a")) {
            out.println("The Minotaur Dances Around You, But Doesn't Come Within Striking Distance.");
            input.nextLine();
            out.println("As you make your lunge, you see him quickly evade you.");
            input.nextLine();
            minoDeath(player);
            return "dead";
        }
        else if (outcome.equals("wrong-c")) {
            death.start();
            out.println("The Minotaur Cackles Haughtily As He Walks Up To You And Kicks You Off The Ledge.");
            input.nextLine();
            out.println("As you hit the ground, your spine breaks in two.");
            out.print("You feel your last breath leave your body.");
            input.nextLine();
            de.stopPlayback(); t.stopPlayback(); mi.stopPlayback(); d.stopPlayback(); m.stopPlayback();
            return "dead";
        }
        else if (outcome.equals("timed-out")) {
            death.start();
            out.println("As you stand gormlessly, the Minotaur rugby tackles you down the stairs.");
            input.nextLine();
            out.println("After a bone-breaking fall you hit the bottom floor and fade into unconsciousness,");
            out.println("hearing the Taurus demon slowly approach you.");
            input.nextLine();
            de.stopPlayback(); t.stopPlayback(); mi.stopPlayback(); d.stopPlayback(); m.stopPlayback();
            return "dead";
        }
        else {
            t.stopPlayback();
            m.stopPlayback();
            mi.stopPlayback();
            out.println("\nThe Minotaur Says He Would Love A Sandwich.");
            input.nextLine();
        if (player.sandwiches < 1) {
            t.stopPlayback();
            out.println("You pull out the empty bag and then realise you have already eaten everything.");
            out.println("> 'I'm sorry, I thought I had some, but I've run out of sandwiches.'");
            input.nextLine();
            out.println("Minotaur:");
            out.println("'It's alright, I'm not that hungry anyway'.");
            input.nextLine();
            out.println("It's a bit awkward for a second,");
            out.println("but then you shuffle past with no hard feelings.");
            input.nextLine();
            out.println("All Of A Sudden");
            minoDeath(player);
            return "dead";
        }

        else {
            String sandwichChoice = "";
            while (!sandwichChoice.equals("a") && !sandwichChoice.equals("b") && !sandwichChoice.equals("c")) {
                out.println("a) You pull one out and hand it over.");
                out.println("b) You decide to make a run for it.");
                if (player.hasGemshorn()) {
                    out.println("c) Subtly spread some dragon's blood from the arrow on to the sandwich.");
                } else {
                    out.println("c) You ask the Minotaur if you can get his number.");
                }
                sandwichChoice = input.nextLine().toLowerCase();
            }
            t.stopPlayback();
            if (sandwichChoice.equals("b")) {
                minoDeath(player);
                return "dead";
            }
            if (sandwichChoice.equals("a") || player.hasGemshorn() && sandwichChoice.equals("c")) {
                out.println("\nAt first he eyes the sandwich with contempt, then eats it in one bite.");
                input.nextLine();
                out.println("He seems to enjoy it quite a bit.");
                input.nextLine();
                out.println("Minotaur: 'Weird, human food.'");
                input.nextLine();
                out.println(player.getName() + ": 'It's cheese and marmite.'");
                input.nextLine();
                out.println("Minotaur:");
            }
            if (sandwichChoice.equals("a")) {
                out.println("'It's a sandwich without passion, a sandwich without purpose.");
                out.println("And quite frankly it is a bland sandwich that does not know itself.'");
                input.nextLine();
                out.println(player.getName() + ": 'Well wi...'");
                minoDeath(player);
                return "dead";
            }
            if (!player.hasGemshorn() && sandwichChoice.equals("c")) {
                out.println("Minotaur:");
                out.println("'OK yeah sure, give me your phone I'll type it in for you.'");
                input.nextLine();
                out.println(player.getName() + ": Ok he...");
                minoDeath(player);
                return "dead";
            } else {
                out.println("'It's a sandwich without passion, a sandwich without purpose.");
                out.println("And quite fra... .... '");
                input.nextLine();
                taurus2.start();
                out.println("The Minotaur Falls Forward, Chundering All About.");
                input.nextLine();
                String chunderChoice = "";
                while (!chunderChoice.equals("a") && !chunderChoice.equals("b") && !chunderChoice.equals("c")) {
                    out.println("a) Run.");
                    out.println("b) Deliver Final Blow.");
                    chunderChoice = input.nextLine().toLowerCase();
                }
                if (chunderChoice.equals("a")) {
                    ShortSound th = new ShortSound("thud.wav");
                    Thread thud = new Thread(th);
                    thud.start();
                    out.println("You decide to make a break for it,");
                    input.nextLine();
                    out.println("‼️but slipping on the Taurus Demon's wine-dark sick,");
                    out.println("you loose your footing and smash your face into the steps.");
                    input.nextLine();
                    minoDeath(player);
                    return "dead";
                } else {
                    ShortSound pl = new ShortSound("plunge_arrow.wav");
                    Thread plungeArrow = new Thread(pl);
                    plungeArrow.start();
                    out.println("\nYou plunge the arrow-tip deep into the fallen Beast's forehead.");
                    input.nextLine();
                    t2.stopPlayback();
                    out.println("Say a prayer for the journey of this lost soul");
                    out.println("before you continue up the megalithic staircase.");
                    try {plungeArrow.join();} catch (InterruptedException e) {;}
                    input.nextLine();
                    out.println("...");
                }
            }
        }
        }
        return "victorious";
    }

    public String play(Player player) {
        depths.start();

        // No gemshorn
        if (!player.hasGemshorn()) {
            out.println("You walk through a stone archway, wondering 'who carved this?'\n");
            Integer abkallu = 0;
            while (abkallu < 1 || abkallu > 4) {
                out.println("1. a friendly Mexican couple");
                out.println("2. dwarves");
                out.println("3. the rocks just happened to form that way naturally");
                out.println("4. the Apkallu sages");
                try {
                    abkallu = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    ;
                }
            }

            if (abkallu == 4) {out.println("\nCorrect 👍🏻");}
            else {out.println("\nIt was the Apkallu");};
            input.nextLine();

            out.println("..You step into a dark 72-storey stone tower..");
            input.nextLine();
            out.println("The megalithic spiral staircase ascends on your right and descends on your left.\n");
            out.println("> 'u' for go up");
            out.println("> 'd' for go down");
            String c1 = "";
            while (!c1.equals("u") && !c1.equals("d")) {
                c1 = input.nextLine().toLowerCase();
            }

            // go down
            if (c1.equals("d")) {
                d.stopPlayback();
                return "serpent";
            }

            // go up
            else {
                out.println("\nIn a state of panic at the grim forebodings below, you run as fast " +
                        "as you can up the spiral staircase.");
                input.nextLine();
                String minotaurOutcome = minotaur(player);
                if (minotaurOutcome.equals("dead")) {
                    return "dead";
                } else {
                    d.stopPlayback();
                    out.println("You arrive at the top of the fortress.");
                    input.nextLine();
                    return "outside";
                }
            }
        }

        // Gemshorn
        else {
            mournful.start();
            String c2 = "";
            out.println("\nAt the base of the tower, you:");
            while (!c2.equals("a") && !c2.equals("b")) {
                out.println("> a) recite a poem to regain your composure");
                out.println("> b) brave these stairs");
                c2 = input.nextLine().toLowerCase();
            }

            if (c2.equals("a")) {
                out.println("\nAnd nothing 'gainst Time's scythe can make defence");
                out.println("Save breed, to brave him when he takes thee hence.");
                input.nextLine();
                String minotaurOutcome = minotaur(player);
                if (minotaurOutcome.equals("dead")) {
                     return "dead";
                }
                else {
                    out.println("Feeling more composed as you walk slowly up the steps,");
                    out.println("after some time you reach the fortress' lofty summit.");
                    input.nextLine();
                    out.println("> Step out into the brisk cold");
                    input.nextLine();
                    t.stopPlayback();
                    d.stopPlayback();
                    m.stopPlayback();
                    return "outside";
                }
            }

            else {
                String minotaurOutcome = minotaur(player);
                if (minotaurOutcome.equals("dead")) {
                    return "dead";
                }
                else {
                    out.println("\nYour heart is pounding as you reach the top.");
                    input.nextLine();
                    out.println("Better to have sweated and not showered than never to have sweated at all.");
                    input.nextLine();
                    out.println("> Step outside into the cold.");
                    input.nextLine();
                    t.stopPlayback();
                    d.stopPlayback();
                    m.stopPlayback();
                    return "outside";
                }
            }
        }
    }
}
