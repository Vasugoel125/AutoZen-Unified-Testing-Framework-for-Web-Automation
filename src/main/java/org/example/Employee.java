package org.example;

import java.util.Scanner;

public class Employee
{
    public static int age;
    public static int empid;
    public static String firstname;
    public static String lastname;
    public static String companyname;
    public Employee()
    {

    }

    public Employee(int age,int empid,String firstname,String lastname,String companyname)
    {
        Scanner sc = new Scanner(System.in);
        this.age = sc.nextInt();
        this.empid = sc.nextInt();
        this.firstname = sc.nextLine();
        this.lastname = sc.nextLine();
        this.companyname = sc.nextLine();
    }

    public Employee(int age,int empid,String firstname,String lastname)
    {
        this.age = age;
        this.empid = empid;
        this.firstname = firstname;
        this.lastname = lastname;
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        age = sc.nextInt();
//        empid = sc.nextInt();
//        firstname = sc.nextLine();
//        lastname = sc.nextLine();
//        companyname = sc.nextLine();
//    }


}
