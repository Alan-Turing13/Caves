package com.caves;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class TimedDecision1 {

    private volatile boolean isRightAnswer;
    String correctResponse;
    private static final Scanner timedInput = new Scanner(System.in);
    private volatile String answer;

    public boolean decision(String correctResponse) {
        this.correctResponse = correctResponse;
        this.isRightAnswer = false;
        this.answer = null;

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

        if (answer != null && answer.equals(correctResponse)) {
            isRightAnswer = true;
        } else {
            isRightAnswer = false;
        }
        return isRightAnswer;
    }
}

