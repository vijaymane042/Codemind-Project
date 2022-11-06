//01112022


package codemind.New.MavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.Current;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityMethods {

	static WebDriver driver;
	public static String getProperty(String key) throws IOException, FileNotFoundException {
		Properties properties = new Properties();
		try
		{
		File file = new File("src/test/resources/masterdata.properties");                     //masterData.properties path
		FileInputStream fileInputStream;

		fileInputStream = new FileInputStream(file);
		properties.load(fileInputStream);

		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		return properties.getProperty(key);
		
	
	}		
public static void scrollTillEndOfThePage(WebDriver driver)
	{
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
	}
		
	
public static void takeScreenShot (WebDriver driver) {
	
		try
		{
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File file=takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("ScreenShot/"+System.currentTimeMillis()+"png"));
		
		}catch(IOException e)
		{
		e.printStackTrace();
		}
		}

		public static void selectValueFromDropDownComingUnderSelectTag(WebElement dropDownLocator ,String dropDownOption){
		Select select = new Select(dropDownLocator);
		select.selectByVisibleText(dropDownOption);
		
}
		public static void waitForPageTitle(WebDriver driver,int duration, String title) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
			wait.until(ExpectedConditions.titleContains(null));
		}
		
		//02112022
		public static void getScreenShot(String name,WebDriver driver)throws IOException{
			TakesScreenshot takeScreenshot=(TakesScreenshot)driver;
			File file=takeScreenshot.getScreenshotAs(OutputType.FILE);
		//	FileUtils.copyFile(file, new File("D:\\Vijay\\Selenium setup\\Screenshot\\"+name+".png"));
		//	FileUtils.copyFile(file, new File("C:\\Users\\vijay\\eclipse-workspace\\CodemindSelniumProject\\ScreenShot"+name+".png"));        //ScreenShotfolder<properties<copy path
FileUtils.copyFile(file, new File("Screenshot"+name+System.currentTimeMillis()+"png"));
		}
		

		
	
}