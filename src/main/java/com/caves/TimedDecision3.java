package com.caves;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class TimedDecision3 {

    String outcome;
    public int seconds;
    private static final Scanner timedInput = new Scanner(System.in);
    private volatile String answer;

    public String decision(String correctResponse) {
        this.answer = null;

        try {
            final CountDownLatch latch = new CountDownLatch(1);

            Thread inputThread = new Thread(() -> {
                answer = timedInput.nextLine().toLowerCase();
                latch.countDown();
            });

            inputThread.start();
            seconds = 4;
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {

                public void run() {
                    // if answer submitted in time
                    if (answer != null || seconds < 0) {
                        timer.cancel();
                        latch.countDown();
                    }
                    seconds--;
                }
            }, 0, 1000);
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (seconds<1) {outcome = "timed-out";}
        else if (answer.equals(correctResponse)) {
            outcome = "correct";
        } else if (answer.equals("a")){
            outcome = "wrong-a";
        } else {
            outcome = "wrong-c";
        }
        return outcome;
    }
}

