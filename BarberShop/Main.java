/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BarberShop;

/**
 *
 * @author Neha satheesh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     
  
        int numChairs = 5;
        BarberShop shop = new BarberShop(numChairs);

        Thread barberThread = new Thread(new Barber(shop));
        barberThread.start();

        for (int i = 1; i <= 10; i++) {
            Thread customerThread = new Thread(new Customer(shop, i));
            customerThread.start();
            try {
                Thread.sleep(200); // Simulate time between customer arrivals
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
    
    
