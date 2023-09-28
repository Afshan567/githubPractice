package com.banking.genericUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpl implements IRetryAnalyzer {
int count=0;
int upperlimit=3;
	@Override
	public boolean retry(ITestResult result) {
		if(count<upperlimit)
		{
			count++;
			return true;
		}
		return false;
	}

}
