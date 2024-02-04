package com.caves;

import com.caves.levels.*;

import java.util.Scanner;

public class Caves {

    // DEATH
    public static void dead() {
        System.out.println("\n------You------died------\n");
        System.out.println("Retry?");
        System.out.println("y/n");
        Scanner input = new Scanner(System.in);
        String retry = "";
        while (!retry.equals("y") && !retry.equals("n")) {
            retry = input.nextLine().toLowerCase();
        }
        if (retry.equals("y")) {
            System.out.println("\n\n...\n\n");
            playGame();
        } else if (retry.equals("n")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame(){

        Player player = new Player();
        Cave level1 = new Cave();

        String cave = level1.play(player);

        // Cheat, go straight to staircase
        if (cave.equals("cheat")) {

            Serpent level4b = new Serpent();
            String serpent = level4b.play(player);

            if (serpent.equals("dead")) {dead();}
            else if (serpent != "") {
                Staircase level5 = new Staircase();
                String staircase2 = level5.play(player);

                if (staircase2.equals("dead")) {dead();}

                else {
                    Outside level6 = new Outside();
                    String outside3 = level6.play(player);

                    if (outside3.equals("dead")) {dead();}

                    else {
                        Muscator level7 = new Muscator();
                        level7.play(player);
                    }
                }
            }
        }

        // Level 2a -> Outside (death inevitable)
        if (cave.equals("outside")) {
            Outside level2 = new Outside();
            level2.play(player);

            // blown off the edge
            dead();
        }

        // Level 2b -> Below
        else {
            Below level2b = new Below();
            String below = level2b.play(player);

            // Level 3 -> Staircase
            if (below != "") {
                Staircase level3 = new Staircase();
                String staircase1 = level3.play(player);

                // if mauled by minotaur
                if (staircase1.equals("dead")) {dead();}

                // Level 4a -> Outside (death inevitable)
                else if (staircase1.equals("outside")) {
                    Outside level2 = new Outside();
                    level2.play(player);
                    dead();
                }

                // Level 4b -> Serpent
                else {
                    Serpent level4b = new Serpent();
                    String serpent = level4b.play(player);

                    // if mauled by serpent
                    if (serpent.equals("dead")) {dead();}

                    // Levels 5+6+7 -> Staircase+Outside+Muscator
                    else if (serpent != "") {
                        Staircase level5 = new Staircase();
                        String staircase2 = level5.play(player);

                        // if mauled by minotaur
                        if (staircase2.equals("dead")) {dead();}

                        else {
                            Outside level6 = new Outside();
                            String outside3 = level6.play(player);

                            // if fall off edge
                            if (outside3.equals("dead")) {dead();}

                            else {
                                // completed the game
                                Muscator level7 = new Muscator();
                                level7.play(player);
                            }
                        }
                    }
                }
            }
        }
    }
}
