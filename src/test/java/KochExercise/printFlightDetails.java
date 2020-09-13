package KochExercise;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.homePage;
import Pages.searchListingPage;
import junit.framework.Assert;
import properties.initializeConfigurations;
import properties.initializeDriver;

public class printFlightDetails 
{
	static WebDriver driver;
	static Properties propC;
	
	@BeforeMethod
	public void preConditions() throws IOException
	{
		initializeDriver d = new initializeDriver();
		driver = d.returnDriver();
		driver.manage().window().maximize(); // Maximize the Window
		
		initializeConfigurations c = new initializeConfigurations(); // Initialize the Configuration File
		propC = c.returnConfiguration();
	}
	
	@SuppressWarnings("deprecation")
	@Test(invocationCount = 5)
	public void printFlightHavingFareLessThan5000() throws IOException, InterruptedException
	{
		driver.get(propC.getProperty("url"));// Step1: Navigate to the URL
		
		String title = driver.getTitle();
				
		Assert.assertTrue(title.equals("ixigo - Flights, Train Reservation, Hotels, Air Tickets, Bus Booking"));
		
		
		homePage h = new homePage(driver);
		h.enterSourceCity();		
		h.enterDestinationCity();
		h.selectDepartureDate();
		h.selectReturnDate();
		h.selectTravellers();
		h.search();
		
		
		searchListingPage s = new searchListingPage(driver);
		s.selectNonStopCheckBox();
		s.printFlightList();
	}
	
	@AfterMethod
	public void postConditions()
	{
		driver.quit();
	}
	
	
}
