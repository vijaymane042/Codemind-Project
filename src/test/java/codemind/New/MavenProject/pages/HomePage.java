//31102022 maven


package codemind.New.MavenProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
	this.driver=driver;
	}
	
		//By UserName= By.xpath("//input[@name='userName']") ;
		WebElement userName ; 
		WebElement password;
		WebElement loginButton;
		WebElement loginSuccessfullyMsg;
		WebElement RegisterLink;

		
		public WebElement getUserName() {
			return userName;
		}

		public void setUserName() {
			userName = driver.findElement(By.xpath("//input[@name='userName']"));
		}

		public WebElement getpassword() {
			return password;
		}

		public void setpassword() {
			password = driver.findElement(By.xpath("//input[@name='password']"));
		}

		public WebElement getloginButton () {
	    return loginButton ;
		}
		
		public void setloginButton () {
			loginButton=driver.findElement(By.xpath("//input[@name='submit']"));
		}

		public WebElement getLoginSuccessfullyMsg() {
			return loginSuccessfullyMsg;
		}

		//public void setLoginSuccessfullyMsg(WebElement loginSuccessfullyMsg) {
		//	this.loginSuccessfullyMsg = loginSuccessfullyMsg;
		
		public void setLoginSuccessfullyMsg() {
			loginSuccessfullyMsg = driver.findElement(By.xpath(" //h3[text()='Login Successfully']"));

		
		}

		public WebElement getRegisterLink() {
			return RegisterLink;
		}

		public void setRegisterLink() {
			RegisterLink = driver.findElement(By.linkText("REGISTER"));
		}
		
		
		
		

	}
