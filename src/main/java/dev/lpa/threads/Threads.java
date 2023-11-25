package dev.lpa.threads;

import static dev.lpa.threads.ThreadColors.ANSI_BLUE;
import static dev.lpa.threads.ThreadColors.ANSI_GREEN;

public class Threads {
    public static void main(String[] args) {

        DataLoader dataLoader = new DataLoader();
        dataLoader.setName("dataLoader");
        dataLoader.start();

        Thread screenThread = new Thread() {
            @Override
            public void run() {
                System.out.println(ANSI_GREEN + "from " + Thread.currentThread().getName());
                try {
                    long starttime = System.currentTimeMillis();
                    dataLoader.join(2000);
                    long elapsedtime = System.currentTimeMillis() - starttime;
                    if (elapsedtime <= 3000) {
                        System.out.println(ANSI_GREEN + "screenThread interrupted dataLoader");
                        System.out.println(ANSI_GREEN + "");
                    } else {
                        System.out.println(ANSI_GREEN + "dataLoader finished on time");
                    }
                } catch (InterruptedException e) {
                    System.out.println(ANSI_GREEN + "screenThread interrupted");
                }
            }
        };

        screenThread.start();

        System.out.println(ANSI_BLUE + "hello from main thread");

    }
}
