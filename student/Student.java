/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Neha satheesh
 */

public class Student {
    private String name;
    private int rollNo,totalMark; 
    private int[] marks;
    public Student() 
    {
        marks=new int[3];
    }
    public void read() throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name : ");
        name=sc.nextLine();
        System.out.print("Enter the roll no : ");
        rollNo=sc.nextInt();
        System.out.print("Enter 3 subject marks : ");
        for(int i=0;i<3;i++)
        {
            marks[i]=sc.nextInt();
        }
    }
    public void calculate()
    {
        totalMark=0;
        for(int i=0;i<3;i++)
        {
            totalMark+=marks[i];
        }
    }
    public int getTotalMark() {
    return totalMark;
    }
 
    public void display()
    {
        System.out.println("Name : "+name);
        System.out.println("Roll No : "+rollNo);
        System.out.print("Marks : ");
        for(int i=0;i<3;i++)
        {
            System.out.print(marks[i]+" ");
        }
        System.out.println("\nTotal Mark : "+totalMark);
    } 

}