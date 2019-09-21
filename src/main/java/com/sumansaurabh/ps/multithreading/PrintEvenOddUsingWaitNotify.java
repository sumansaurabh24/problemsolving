package com.sumansaurabh.ps.multithreading;

public class PrintEvenOddUsingWaitNotify {

    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        TaskEvenOdd taskEven = new TaskEvenOdd(printer, 10 , true);
        TaskEvenOdd taskOdd = new TaskEvenOdd(printer, 10, false);

        Thread thread1 = new Thread(taskOdd);
        Thread thread2 = new Thread(taskEven);

        thread1.start();
        thread2.start();
    }
}

class Printer {

    private volatile boolean isOdd;

    public synchronized void printEven(int number) {
        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Even: " + number);
        isOdd = false;
        notifyAll();
    }

    public synchronized void printOdd(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Odd: " + number);
        isOdd = true;
        notifyAll();
    }
}
class TaskEvenOdd implements Runnable{

    Printer printer;
    int max;
    boolean isEven;

    public TaskEvenOdd(Printer printer, int max, boolean isEven) {
        this.printer = printer;
        this.max = max;
        this.isEven = isEven;
    }

    @Override
    public void run() {
        int number = isEven ? 2 : 1;
        while (number <= max){
            if(isEven){
                printer.printEven(number);
            }else{
                printer.printOdd(number);
            }

            number = number + 2;
        }
    }
}