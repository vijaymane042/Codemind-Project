//31112022 maven
//Execution of test cases -testing.xml - codemind.New.MavenProject.testCases<TestNG<convert to testng<finish

package codemind.New.MavenProject.testCases;

import org.testng.annotations.Test;

//@Listeners(TestNgListner.class)

import org.testng.Assert;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//@Listner(TestNGListners.class)

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import codemind.New.MavenProject.UtilityMethods;
import codemind.New.MavenProject.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.codec.http.HttpContentEncoder.Result;

public class HomePageTestCase {

	WebDriver driver;
	HomePage homePage;
	public static String LOGIN_SUCC_MSG="Login Successfully";

	@BeforeMethod

	public void initilizeBrowser() {
		//System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe"); // UniqueRelative path

		//System.setProperty("webdriver.chrome.driver","C:\\Users\\vijay\\eclipse-workspace\\CodemindSelniumProject\\src\\test\\java\\chromedriver.exe");

		 WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test( dataProvider="myDataProvider")//description="This test case with data provider") ;
//	public void verifyValidLogin() throws FileNotFoundException, IOException {
	public void verifyValidLogin (String username ,String password ) throws FileNotFoundException, IOException{
		//driver.get("https://demo.guru99.com/test/newtours/index.php");
		try {
			driver.get(UtilityMethods.getProperty("url"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                                           //01112022
		homePage = new HomePage(driver);
		//driver.get(UtilityMethods.getProperty("url"));
		homePage.setUserName();
		homePage.getUserName().sendKeys("username");
		homePage.setpassword();
		homePage.getpassword().sendKeys("password");
		homePage.setloginButton();
		homePage.getloginButton().click();
		UtilityMethods.scrollTillEndOfThePage(driver);                     //02112022
		//01112022
		homePage.setLoginSuccessfullyMsg();
		assertEquals(homePage.getLoginSuccessfullyMsg().getText(), "Login Successfully");
		//AssertJUnit.assertEquals(homePage.getLoginSuccessfullyMsg().getText(),HomePageTestCase.LOGIN_SUCC_MSG);
		//Softassert is also known as verify 
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(homePage.getLoginSuccessfullyMsg().getText(), HomePageTestCase.LOGIN_SUCC_MSG);
		//softAssert.assertEquals(homePage.getLoginSuccessfullyMsg().getText(), "Login Successfully");
		UtilityMethods.takeScreenShot(driver);

	}

/*	//@Test
	//@Test(enabled = false)
	@Test(enabled = true)

	public void verifyRegistrationFunctionality() {
		homePage = new HomePage(driver);
		homePage.getRegisterLink().click();
		homePage.setRegisterLink();
		homePage.getRegisterLink().click();
		//assertTrue(driver.getTitle().equals("Register: Mercury Tour") ,"Title does not matched "));                 //Test casefailed
		Assert.assertTrue(driver.getTitle().equals("Register: Mercury Tours") ,"Title does not matched ");

	}*/
	
	@org.testng.annotations.DataProvider(name = "myDataProvider")
	public String[][] dataProvider() {
		//String array[][] = { { "user1", "password1" }, { "user2", "password2" }, { "user3", "password3" } };
		String array[][] = { { "user1", "password1" }};

		return array;
	}
	
	@Test()
	public void verifyRegistrationFunctionality() throws FileNotFoundException, IOException {
		homePage = new HomePage(driver);
		driver.get(UtilityMethods.getProperty("url"));
		homePage.setRegisterLink();
		homePage.getRegisterLink().click();
		assertTrue(driver.getTitle().equals("Register: Mercury Tours"), "Title doesn't matched");

	}

	
	@AfterMethod
	public void tearDown (ITestResult result) {

			if (result.getStatus() == ITestResult.FAILURE) {
				try {
					UtilityMethods.getScreenShot(result.getName()+System.currentTimeMillis(),driver);
				} catch (IOException e) {
					// TODO Auto-generated method stub
					e.printStackTrace();
				}
		
			}
		driver.quit();
	}
	
	
	
	}	


