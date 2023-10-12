/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BarberShop;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Neha satheesh
 */
public class BarberShop {
    private int numChairs;
    private Semaphore barberAvailable = new Semaphore(1);
    private Semaphore customersWaiting = new Semaphore(0);
    private Semaphore barberDone = new Semaphore(0);

    public BarberShop(int numChairs) {
        this.numChairs = numChairs;
    }

    public void customerArrives(int customerId) throws InterruptedException {
        if (customersWaiting.availablePermits() < numChairs) {
            System.out.println("Customer " + customerId + " is waiting.");
            customersWaiting.release();
            barberAvailable.acquire();
            getHaircut(customerId);
        } else {
            System.out.println("Customer " + customerId + " leaves because the shop is full.");
        }
    }

    public void barberCutsHair() throws InterruptedException {
        while (true) {
            customersWaiting.acquire();
            barberAvailable.release();
            System.out.println("Barber is cutting hair.");
            Thread.sleep(100); // Simulate haircut time
            System.out.println("Barber finished cutting hair.");
            barberDone.release();
        }
    }

    public void getHaircut(int customerId) throws InterruptedException {
        barberDone.acquire();
        System.out.println("Customer " + customerId + " is getting a haircut.");
    }
}

class Customer implements Runnable {
    private BarberShop shop;
    private int customerId;

    public Customer(BarberShop shop, int customerId) {
        this.shop = shop;
        this.customerId = customerId;
    }

    @Override
    public void run() {
        try {
            shop.customerArrives(customerId);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Barber implements Runnable {
    private BarberShop shop;

    public Barber(BarberShop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            shop.barberCutsHair();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


