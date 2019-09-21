package com.sumansaurabh.ps.multithreading;

import java.util.concurrent.Semaphore;

public class PrintEvenOddUsingSemaphore {

    public static void main(String[] args) {
        SharedPrinter sharedPrinter = new SharedPrinter();
        Even evenTask = new Even(sharedPrinter, 10);
        Odd oddTask = new Odd(sharedPrinter, 10);

        Thread thread1 = new Thread(oddTask);
        Thread thread2 = new Thread(evenTask);

        thread1.start();
        thread2.start();
    }
}

class SharedPrinter{

    private Semaphore semEven = new Semaphore(0);
    private Semaphore semOdd = new Semaphore(1);

    void printEvenNum(int num) {
        try {
            semEven.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " : " + num);
        semOdd.release();
    }

    void printOddNum(int num) {
        try {
            semOdd.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " : " + num);
        semEven.release();

    }
}

class Even implements Runnable{

    private SharedPrinter sharedPrinter;
    private int max;

    public Even(SharedPrinter sharedPrinter, int max) {
        this.sharedPrinter = sharedPrinter;
        this.max = max;
    }

    @Override
    public void run() {
        for(int i = 2; i < max; i= i+2){
            sharedPrinter.printEvenNum(i);
        }
    }
}

class Odd implements Runnable{

    private SharedPrinter sharedPrinter;
    private int max;

    public Odd(SharedPrinter sharedPrinter, int max) {
        this.sharedPrinter = sharedPrinter;
        this.max = max;
    }

    @Override
    public void run() {
        for(int i = 1; i < max; i= i+2){
            sharedPrinter.printOddNum(i);
        }
    }
}
