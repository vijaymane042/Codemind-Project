//01112022


package codemind.New.MavenProject.testCases;

import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import codemind.New.MavenProject.TestNGListners;
import codemind.New.MavenProject.UtilityMethods;
//@Listeners(TestNGListners.class)
import codemind.New.MavenProject.pages.HomePage;
import codemind.New.MavenProject.pages.RegistrationPage;


public class RegistrationTestCases {

	WebDriver driver;
	HomePage homePage;
	RegistrationPage registrationPage ;

	@BeforeMethod

	public void initilizeBrowser() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");               //UniqueRelative path 
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\vijay\\eclipse-workspace\\CodemindSelniumProject\\src\\test\\java\\chromedriver.exe");

		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}//01112022
	@Test
	public void verifySuccessFulRegistration () {
		
		homePage = new HomePage(driver);
		registrationPage = new RegistrationPage(driver);
		try {
			driver.get(UtilityMethods.getProperty("url"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		homePage.setRegisterLink();
		homePage.getRegisterLink().click();;
		UtilityMethods.waitForPageTitle(driver, 5 ,"Register: Mercury Tour");
		registrationPage.setFirstNameTextBox();
		registrationPage.getFirstNameTextBox().sendKeys("ABC");
		registrationPage.setCountryDropDown();
		UtilityMethods.selectValueFromDropDownComingUnderSelectTag(registrationPage.getCountryDropDown(),"INDIA");
		registrationPage.setSubmitButton();
		registrationPage.getSubmitButton().click();
		registrationPage.setRegistrationSuccessFullMsg();
		String msg = registrationPage.getRegistrationSuccessFullMsg().getText();
		assertTrue(msg.contains("sachin"));
		//Assert.assertTrue(registrationPage.getRegistrationSuccessFullMsg ().getText().contains("sachin"));

		
	}

	@AfterMethod
	public void tearDown (ITestResult result){
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				UtilityMethods.getScreenShot(result.getName()+System.currentTimeMillis(),driver);
			} catch (IOException e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		driver.quit();
	}
	}
}
	
	













