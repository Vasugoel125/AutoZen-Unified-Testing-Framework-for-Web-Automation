package org.example;

import java.util.Scanner;

public class objtest
{
    public static void main(String[] args)
    {
        Employee emp1 = new Employee(Employee.age,Employee.empid,Employee.firstname,Employee.lastname,Employee.companyname);
        new Employee().age = 35;
//        Employee.age = 21;
//        Employee.empid = 101;
//        Employee.firstname = "Vasu";
//        Employee.lastname = "Goel";
//        System.out.println(Employee.age + " " + Employee.empid + " " + Employee.firstname + " " + Employee.lastname);
//        System.out.println(emp1.sum(4,5));
//        Employee.empid = 21;
//        System.out.println(emp1.empid);
        Employee emp2 = new Employee(emp1.age,emp1.empid,emp1.firstname,emp1.lastname);
        System.out.println(emp2.age);
        System.out.println(emp2.empid);
        System.out.println(emp2.firstname);
        System.out.println(emp2.lastname);
    }
}
