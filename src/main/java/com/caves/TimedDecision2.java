package com.caves;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class TimedDecision2 {

    private volatile boolean rightAnswer;
    /* Answer is right if user response contains a word from the first array AND
    a word from the second array, which arrays are passed in from the level. */
    private String[] answer1stHalf = new String[4];
    private String[] answer2ndHalf = new String[4];
    boolean ans1half=false;
    boolean ans2half=false;

    public TimedDecision2(String[] ans1, String[] ans2){
        this.answer1stHalf = ans1;
        this.answer2ndHalf = ans2;
    }

    private static final Scanner timedInput = new Scanner(System.in);
    private static volatile String answer = null;

    public boolean decision() {

        try {
            final CountDownLatch latch = new CountDownLatch(1);

            Thread inputThread = new Thread(() -> {
                answer = timedInput.nextLine().toLowerCase();
                latch.countDown();
            });

            inputThread.start();

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                int i = 6;

                public void run() {
                    if (answer != null || i < 0) {
                        timer.cancel();
                        latch.countDown();
                    }
                    i--;
                }
            }, 0, 1000);
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (String word : answer1stHalf)
            if (answer.contains(word)) {
                ans1half = true;
            }
        for (String word : answer2ndHalf)
            if (answer.contains(word)) {
                ans2half = true;
            }
        if (ans1half == true && ans2half == true) {
            rightAnswer = true;
        } else {
            rightAnswer = false;
        }

        return rightAnswer;
    }
}
