package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.PageBase;

public class HomePage extends PageBase {
	public HomePage(WebDriver driver) {
		super(driver);
	}
	// define the locators of the webelement
	By searchInputTxt = By.id("location-search");
	By categoryLink = By.xpath("//a[@data-name='Desserts and sweet dishes']");
	By firstAdressInDropDown = By.xpath("//button[@class='ccl-224a39591f0cfb3e']");
	By weAreNotThereAlert = By.xpath("//div[@class='ccl-c334cd44f5e42880']");
	By emailInputTxt = By.id("vote-area-email-input");
	By emailButton = By.xpath("//button[@type='submit']");
	By successMsg = By.xpath("//Span[@class='VoteAreaModal-c5aefb293d12aff9']");
	// write the test methods
	public void searchforAddress(String Address)
	{
		driver.findElement(searchInputTxt).sendKeys(Address);
		driver.findElement(firstAdressInDropDown).click();
		
	}
	
	public void selectSpecificCategory()

	{
		driver.findElement(categoryLink).click();
	}

	public String respondToWeArenotThereAlert()
	{
		driver.findElement(weAreNotThereAlert);
		driver.findElement(emailInputTxt).sendKeys("AutomatedEmail@hotmail.com");
		driver.findElement(emailButton).click();
		String msg = driver.findElement(successMsg).getText();
		System.out.println(msg);
		return msg;
		
	}
}
