//02112022 maven


package codemind.New.MavenProject;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import TestNG.LoginScenarioWithListners;

public class TestNGListner {
	
	public class TestNGListners implements ITestListener {                //ItestListner -kind of listner shows result of latest test case

		@Override
		public void onTestStart(ITestResult result) {
			Reporter.log("Test case started"+result.getName());
			//System.out.println("Test case started");
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			Reporter.log("Test case Passed"+result.getName());

		}

		@Override
		//public void onTestFailure(ITestResult result,WebDriver driver {
		public void onTestFailure(ITestResult result {

//			if (result.getStatus() == result.FAILURE) {
//				try {
//					UtilityMethods.getScreenShot(result.getName(),driver);
//				//	LoginScenarioWithListners.getScreenShot(result.getName()+System.currentTimeMillis());
//				} catch (IOException e) {
//					// TODO Auto-generated method stub
//					e.printStackTrace();
//				}
//				Reporter.log("Tests Case failed " + result.getName());
//				//UtilityMethods.getScreenshot
			}
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub

		}

	}


}
