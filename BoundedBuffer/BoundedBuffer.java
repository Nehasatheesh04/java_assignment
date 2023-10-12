/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BoundedBuffer;

/**
 *
 * @author Neha satheesh
 */
public class BoundedBuffer {
     private int[] buffer;
    private int size;
    private int count;
    private int in;
    private int out;

    public BoundedBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.count = 0;
        this.in = 0;
        this.out = 0;
    }

    public synchronized void put(int item) throws InterruptedException {
        while (count == size) {
            wait();
        }

        buffer[in] = item;
        in = (in + 1) % size;
        count++;

        notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (count == 0) {
            wait();
        }

        int item = buffer[out];
        out = (out + 1) % size;
        count--;

        notifyAll();

        return item;
    }
}


