//01112022


package codemind.New.MavenProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Listners(TestNGListners.class)

public class RegistrationPage {

	WebDriver driver;
	WebElement FirstNameTextBox;
	WebElement SubmitButton;
	WebElement CountryDropDown;
	WebElement registrationSuccessFullMsg ;
	
	public RegistrationPage(WebDriver driver) {
	this.driver=driver;
}

	public WebElement getFirstNameTextBox() {
		return FirstNameTextBox;
	}

	public void setFirstNameTextBox(WebElement firstNameTextBox) {
	 firstNameTextBox =driver.findElement(By.xpath("//input[@name='firstname']"));
	}

	public WebElement getSubmitButton() {
		return SubmitButton;
	}

	public void setSubmitButton() {
	SubmitButton=driver.findElement(By.xpath("//input[@name='submitButton']"));
	}

	public WebElement getCountryDropDown() {
		return CountryDropDown;
	}

	public void setCountryDropDown(WebElement countryDropDown) {
		countryDropDown=driver.findElement(By.xpath("//input[@name='Country']"));
	}

	public WebElement getRegistrationSuccessFullMsg() {
		return registrationSuccessFullMsg;
	}

	public static void setRegistrationSuccessFullMsg() {
	registrationSuccessFullMsg = driver.findElement(By.xpath("//*[contains(text(),'Dear')]"));
	}
}