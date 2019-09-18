package org.spring.demo.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("ListenerClass:: Method: onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("ListenerClass:: Method: onTestSuccess");
		System.out.println("Success of test cases and its details are : "+result.getName());		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("ListenerClass:: Method: onTestFailure");
		System.out.println("Failure of test cases and its details are : "+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("ListenerClass:: Method: onTestSkipped");
		System.out.println("Skip of test cases and its details are : "+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("ListenerClass:: Method: onTestFailedButWithinSuccessPercentage");
		System.out.println("Failure of test cases and its details are : "+result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("ListenerClass:: Method: onStart");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("ListenerClass:: Method: onFinish");
		
	}
}