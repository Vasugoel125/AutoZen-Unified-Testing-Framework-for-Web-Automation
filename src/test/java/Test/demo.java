package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class demo
{
    public static void main(String[] args)
    {
//        String a = "Copy of abc";
//        String b = "abc";
//        if(a.equalsIgnoreCase("Copy of "+b))
//        {
//            System.out.println("equal");
//        }
//        else
//        {
//            System.out.println("Not equal");
//        }

        String str[] = {"-2,343.00","-4,568.00","8.79"};
        float finalAmount = 0;
        for (int i = 0; i < str.length; i++)
        {
            if(!str[i].contains("-"))
            {
                String str2 = str[i].replace(",","");
                System.out.println("str2 = " + str2);
                finalAmount = finalAmount + (Float.parseFloat(str2));
                System.out.println("finalAmount = " + finalAmount);
            }
        }
        System.out.println("finalAmount = " + finalAmount);
//        System.out.println("str2 = " + str2);
//        double number = Double.parseDouble(str2);
//        System.out.println("number = " + number);
    }
}
