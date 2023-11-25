package dev.lpa.threads;

import static dev.lpa.threads.ThreadColors.ANSI_BLUE;
import static dev.lpa.threads.ThreadColors.ANSI_RED;

public class DataLoader extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "I am interrupted!");
            return;
        }
        System.out.println(ANSI_RED + "I am done");
    }
}
