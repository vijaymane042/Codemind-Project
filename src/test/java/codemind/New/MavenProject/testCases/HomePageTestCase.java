//31112022 maven
//Execution of test cases -testing.xml - codemind.New.MavenProject.testCases<TestNG<convert to testng<finish

package codemind.New.MavenProject.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

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
import io.netty.handler.codec.http.HttpContentEncoder.Result;

public class HomePageTestCase {

	WebDriver driver;
	HomePage homePage;

	@BeforeMethod

	public void initilizeBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe"); // UniqueRelative path

		// System.setProperty("webdriver.chrome.driver","C:\\Users\\vijay\\eclipse-workspace\\CodemindSelniumProject\\src\\test\\java\\chromedriver.exe");

		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test( dataProvider="myDataProvider") 
//	public void verifyValidLogin() throws FileNotFoundException, IOException {
	public void verifyValidLogin (String username ,String password ){
		//driver.get("https://demo.guru99.com/test/newtours/index.php");
		driver.get(UtilityMethods.getProperty("url"));                                           //01112022
		homePage = new HomePage(driver);
		homePage.setUserName();
		homePage.getUserName().sendKeys("username");
		homePage.setpassword();
		homePage.getpassword().sendKeys("password");
		homePage.setloginButton();
		homePage.getloginButton().click();
		UtilityMethods.scrollTillEndOfThePage(driver);                     //02112022
		//01112022
		homePage.setLoginSuccessfullyMsg();
		AssertJUnit.assertEquals(homePage.getLoginSuccessfullyMsg().getText(), "Login Successfully");
		//Softassert is also known as verify 
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(homePage.getLoginSuccessfullyMsg().getText(), "Login Successfully");
		UtilityMethods.takeScreenShot(driver);

	}

	//@Test
	//@Test(enabled = false)
	@Test(enabled = True)

	public void verifyRegistrationFunctionality() {
		homePage = new HomePage(driver);
		homePage = getRegisterLink().click();
		homePage.setRegisterLink();
		homePage.getRegisterLink().click();
		//assertTrue(driver.getTitle().equals("Register: Mercury Tour") ,"Title does not matched "));                 //Test casefailed
		assertTrue(driver.getTitle().equals("Register: Mercury Tours") ,"Title does not matched "));

	}
	
	@org.testng.annotations.DataProvider(name = "myDataProvider")
	public String[][] dataProvider() {
		//String array[][] = { { "user1", "password1" }, { "user2", "password2" }, { "user3", "password3" } };
		String array[][] = { { "user1", "password1" }};

		return array;
	}
	@Test
	public void verifySuccessfulRegistration () {
	}
	
	@AfterMethod
	public void tearDown (ITestResult result) {

			if (result.getStatus() == result.FAILURE) {
				try {
					UtilityMethods.getScreenShot(result.getName(),System.currentTimeMillis());
				} catch (IOException e) {
					// TODO Auto-generated method stub
					e.printStackTrace();
				}
		
			}
		driver.quit();
	}
	
	
	
	}	


