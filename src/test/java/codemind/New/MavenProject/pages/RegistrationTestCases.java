//01112022


package codemind.New.MavenProject.pages;

import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import codemind.New.MavenProject.TestNGListner;
import codemind.New.MavenProject.UtilityMethods;
@Listeners(TestNGListner.class)


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
		driver.get(UtilityMethods.getProperty("url"));                                           //01112022
		registrationPage = new RegistrationPage(driver);
		homePage = new HomePage(driver);
		homePage.setRegisterLink();
		homePage.getRegisterLink();
		UtilityMethods.waitForPageTitle(driver, 5 ,"Register: Mercury Tour")();
		registrationPage.setFirstNameTextBox(null)();
		registrationPage.getFirstNameTextBox().sendKeys(null)();
		registrationPage.setCountryDropDown();
		UtilityMethods.selectValueFromDropDownComingUnderSelectTag(registrationPage, getCountryDropDown,"INDIA")();
		registrationPage.getSubmitButton,click();
		registrationPage.setSubmitButton().click();
		RegistrationPage.setRegistrationSuccessFullMsg ();
		assertTrue(.RegistrationPage.getRegistrationSuccessFullMsg ().getText().contains("sachin"));

		
		
	}
	@AfterMethod
	@AfterMethod
	public void tearDown (ITestResult result){
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				UtilityMethods.getScreenShot(result.getName(),System.currentTimeMillis());
			} catch (IOException e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		driver.quit();
	}
	
	
	
}












