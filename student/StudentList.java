/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.io.IOException;

/**
 *
 * @author Neha satheesh
 */
public class StudentList {
    int count; 
    Student[] students;
    public StudentList(int count) {
 
    this.count = count;
    students = new Student[count];
 
    }
    public void readList() throws IOException{
 
        for(int i=0;i<count;i++) 
        {
            students[i]=new Student();
            students[i].read();
            students[i].calculate(); 
        } 
    }
    public void sort()
    {
        for(int i=1;i<count;i++){
            Student current = students[i];
            int k=i-1;
            while(k>=0 && current.getTotalMark()>students[k].getTotalMark())
            {
                students[k+1]=students[k];
                k--;
            }
            students[k+1]=current;
        }
    }
    public void displayList()
    {
        for(int i=0;i<count;i++) 
        {
            students[i].display();
        }
    
    }
}