package DeliverooFWTestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Base.TestBase;
import Pages.HomePage;

public class SearchTests  extends TestBase
{
	HomePage homePageObject;
    @Test 
	public void searchForAddressHasDelivaryServiceTest()
    {
    	homePageObject = new HomePage(driver);
    	homePageObject.selectSpecificCategory();
    	homePageObject.searchforAddress("St Pancras Station");
    	
    	//I didn't make conditional wait because I need to verify that page redirection happened
    	// I used already the implicit wait before each method in TestBase parent class
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}    	
    	//assert with page title (Takeaway delivery in Euston - Order with Deliveroo)
    	String actualTitle = driver.getTitle();
    	String expectedTitle = "Takeaway delivery in Euston - Order with Deliveroo";
    	assertEquals(actualTitle, expectedTitle);
    }
    
    @Test
    public void SearchForAddressHasNoDelivaryServiceTest()
    {
    	homePageObject = new HomePage(driver);
    	homePageObject.searchforAddress("Stansted Airport, Stansted CM24 1RW, UK");
    	String actualMsg = homePageObject.respondToWeArenotThereAlert();
    	System.out.println(actualMsg);
    	String expectedMsg = "Thanks – we’ll let you know when we’re there!";
    	assertEquals(actualMsg,expectedMsg);
    	    	
    }
}
