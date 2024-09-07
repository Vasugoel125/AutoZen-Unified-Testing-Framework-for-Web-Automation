package Test;

import org.testng.annotations.*;

public class testMethods
{
    @BeforeSuite
    public void beforesuit()  // suite > before/after test > class > methods > Tests   // creating database connection, reports initialization
    {
        System.out.println("Im in before suit");
    }
    @BeforeTest
    public void beforeTest()   // collection on classes
    {
        System.out.println("I am in before test");
    }
    @BeforeClass
    public void beforeclass()   // collection of methods
    {
        System.out.println("I am in before class");
    }
    @BeforeMethod
    public void setup()
    {
        System.out.println("I am in before method");
    }
    @Test
    public void checkitem()
    {
        System.out.println("Checking the test case here");
    }
    @AfterMethod
    public void teardown()
    {
        System.out.println("I am in after method");
    }
    @AfterClass
    public void afterclass()
    {
        System.out.println("I am in after class");
    }
    @AfterTest
    public void aftertest()
    {
        System.out.println("I am in after test");
    }

    @AfterSuite
    public void aftersuit()   // close database connection, close reports
    {
        System.out.println("Im in after suit");
    }

}
