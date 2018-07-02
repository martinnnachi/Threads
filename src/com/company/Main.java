package com.company;

import static com.company.ThreadColor.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(ANSI_PURPLE + "Hello from the main thread");
        final Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        //anonymous class
        new Thread(() -> System.out.println(ANSI_GREEN + "Hello from the anonymous class Thread")).start();

        Thread myRunnableThread = new Thread(new MyRunnable() {

            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run()");
                try {
                    anotherThread.join();
                    System.out.println(ANSI_RED + "Another thread terminated or timed out, so i'm running again");
                }catch (InterruptedException e){
                    System.out.println(ANSI_RED + "I couldn't wait after all. I was interrupted");
                }
            }
        });
        myRunnableThread.start();

        System.out.println(ANSI_BLUE + "Hello again from the main thread");
    }
}
