package com.sumansaurabh.ps.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPool {

    private ConcurrentLinkedQueue<Runnable> runnables;
    private List<WorkerThread> threads;
    private AtomicBoolean execute;

    public ThreadPool(int threadCount) {
        runnables = new ConcurrentLinkedQueue<>();
        threads = new ArrayList<>();
        execute = new AtomicBoolean(true);
        for(int i = 0; i < threadCount ; i++){
            WorkerThread workerThread = new WorkerThread(runnables, execute, "CTP : " + i);
            workerThread.start();
            threads.add(workerThread);
        }
    }

    public void execute(Runnable runnable){
        if(execute.get()){
            runnables.add(runnable);
        }
    }

    public void terminate(){
        execute.set(false);
        runnables.clear();
    }
}
class WorkerThread extends Thread{

    private ConcurrentLinkedQueue<Runnable> runnables;
    private AtomicBoolean execute;

    public WorkerThread(ConcurrentLinkedQueue<Runnable> runnables, AtomicBoolean execute, String name){
        this.runnables = runnables;
        this.execute = execute;
        super.setName(name);
    }

    @Override
    public void run() {

        try {
            while (execute.get() || !runnables.isEmpty()){
                Runnable runnable = runnables.poll();

                if (runnable != null){
                    System.out.println(Thread.currentThread().getName() + " executing...");
                    runnable.run();
                }
            }
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Executor{

    public static void main(String[] args) {

        ThreadPool pool = new ThreadPool(2);

        //Task
        for(int i = 0; i < 2; i++){
            Task task = new Task(i);
            pool.execute(task);
        }

        pool.terminate();

    }
}
class Task implements Runnable{
    private int number;

    public Task(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("I am runnable "+ number);
    }
}