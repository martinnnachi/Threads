package com.martinnnachi;

import static com.martinnnachi.ThreadColor.ANSI_GREEN;
import static com.martinnnachi.ThreadColor.ANSI_PURPLE;
import static com.martinnnachi.ThreadColor.ANSI_RED;

public class Main {

    public static void main(String[] args) {

        System.out.println(ANSI_PURPLE + "Hello from the main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread() { //anonymous class

            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class Thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {

            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run()");
            }
        });
        myRunnableThread.start();

        System.out.println(ANSI_PURPLE + "Hello again from the main thread");
    }
}
