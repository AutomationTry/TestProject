package Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

public class ListenersTest implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("******** Test started :" + result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("******** Success :" + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("******** Failure :" + result.getName());

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("******** Skipped :" + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		System.out.println("******** Test finished :" + context.getName());

	}

}
