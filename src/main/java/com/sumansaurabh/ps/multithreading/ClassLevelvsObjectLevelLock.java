package com.sumansaurabh.ps.multithreading;

public class ClassLevelvsObjectLevelLock {

    public static void main(String[] args) {

        ClassToBeLocked object = new ClassToBeLocked();
        TaskCheck taskCheck = new TaskCheck(object, true);
        TaskCheck taskCheck1 = new TaskCheck(object, false);

        Thread t1 = new Thread(taskCheck);
        t1.setName("Class Level Check Thread");
        Thread t2 = new Thread(taskCheck1);
        t2.setName("Object Level Check Thread");

        t1.start();
        t2.start();

    }
}

class TaskCheck implements Runnable {

    private ClassToBeLocked classToBeLocked;
    private boolean classLevelCheck;

    public TaskCheck(ClassToBeLocked classToBeLocked, boolean classLevelCheck) {
        this.classToBeLocked = classToBeLocked;
        this.classLevelCheck = classLevelCheck;
    }

    @Override
    public void run() {
        if (classLevelCheck) {
            ClassToBeLocked.doSomethingStatic();
        } else {
            classToBeLocked.doSomething();
        }
    }
}

class ClassToBeLocked {

    public static synchronized void doSomethingStatic() {

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void doSomething() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
