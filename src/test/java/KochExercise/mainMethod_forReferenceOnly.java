package KochExercise;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Pages.homePage;
import Pages.searchListingPage;
import properties.initializeConfigurations;
import properties.initializeDriver;

public class mainMethod_forReferenceOnly
{
	static WebDriver driver;
	static Properties propC;
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		initializeDriver d = new initializeDriver();
		driver = d.returnDriver();
		driver.manage().window().maximize(); // Maximize the Window
		
		initializeConfigurations c = new initializeConfigurations(); // Initialize the Configuration File
		propC = c.returnConfiguration();
		
		driver.get(propC.getProperty("url"));// Step1: Navigate to the URL
		
		
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
		
		
		driver.quit();
		
		
		
	}
}
