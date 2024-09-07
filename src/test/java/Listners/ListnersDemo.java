package Listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersDemo implements ITestListener
{
    @Override
    public void onTestStart(ITestResult result)  // before method --> starting the task
    {
        System.out.println(result.getName() + " is started");
    }
    @Override
    public void onTestSuccess(ITestResult result)  // after method --> on passing the test case
    {
        System.out.println(result.getName() + " is passed");
    }
    @Override
    public void onTestFailure(ITestResult result) // after method --> on failing the test case
    {
        System.out.println(result.getName() + " is failed");
    }
    @Override
    public void onTestSkipped(ITestResult result)  // after method --> on skipping the test case
    {
        System.out.println(result.getName() + " is skipped");
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)  // after  method --> on failing the test case but with some success percentage
    {
        System.out.println(result.getName() + " is failed with some success percentage");
    }
    @Override
    public void onTestFailedWithTimeout(ITestResult result) // after method --> on failing the test case because of the time out
    {
        System.out.println(result.getName() + " is failed because of time out");
    }
    @Override
    public void onStart(ITestContext context)  // before suit --> starting the task from the scratch
    {
        System.out.println(context.getName() + " is started in suit");
    }
    @Override
    public void onFinish(ITestContext context)  //  after suit  --> after completing all the task
    {
        System.out.println(context.getName() + " is ended in suit");
    }
}
