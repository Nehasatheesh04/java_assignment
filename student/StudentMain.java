/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package student;

import java.io.IOException;

/**
 *
 * @author Neha satheesh
 */
public class StudentMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        StudentList slist= new StudentList(3);
        slist.readList();
        slist.sort();
        slist.displayList();

    }
    
}