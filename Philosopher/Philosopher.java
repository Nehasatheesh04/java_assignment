/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Philosopher;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Neha satheesh
 */
public class Philosopher implements Runnable  {
     private int id;
    private Semaphore leftFork;
    private Semaphore rightFork;

    public Philosopher(int id, Semaphore leftFork, Semaphore rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                pickUpForks();
                eat();
                putDownForks();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking.");
        Thread.sleep(100); // Simulate thinking time
    }

    private void pickUpForks() throws InterruptedException {
        leftFork.acquire();
        System.out.println("Philosopher " + id + " picked up left fork.");
        rightFork.acquire();
        System.out.println("Philosopher " + id + " picked up right fork.");
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is eating.");
        Thread.sleep(150); // Simulate eating time
    }

    private void putDownForks() {
        leftFork.release();
        System.out.println("Philosopher " + id + " put down left fork.");
        rightFork.release();
        System.out.println("Philosopher " + id + " put down right fork.");
    }
}
