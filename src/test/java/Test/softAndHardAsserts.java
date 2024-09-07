package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAndHardAsserts
{
    SoftAssert soft_assert = new SoftAssert();
    @Test
    public void testing()
    {
        soft_assert.assertEquals(true,false); // if it gets fail it will let other lines of code get executed
        System.out.println("Hello World!!");
        Assert.assertEquals(true,false);  // if it fails it will not let the compiler to go the next line of code
        System.out.println("Hello World!");
    }
}
