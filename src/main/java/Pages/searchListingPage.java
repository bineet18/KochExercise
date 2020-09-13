package Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import properties.initializeXpaths;

public class searchListingPage  extends initializeXpaths
{
	WebDriver driver;
	Properties propX;
	
	public searchListingPage(WebDriver driver) throws IOException 
	{
    	this.driver = driver;
		this.propX = super.propX;
	}
	
	public void selectNonStopCheckBox()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40); 
		WebElement nonStopCheckBox; 
		nonStopCheckBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(propX.getProperty("nonStopCheckBox")))); 
		nonStopCheckBox.click();
		
	}
	
	public void printFlightList()
	{
		List<List<String>> airlineDetails = new ArrayList<List<String>>();
		List<WebElement> airlineNumbers = new ArrayList<WebElement>();
		List<WebElement> departureTimes = new ArrayList<WebElement>();
		List<WebElement> fares = new ArrayList<WebElement>();
		List<String> temp;
		
		airlineNumbers = driver.findElements(By.xpath(propX.getProperty("airlineNumber")));
		departureTimes = driver.findElements(By.xpath(propX.getProperty("departureTime")));
		fares = driver.findElements(By.xpath(propX.getProperty("fare")));
		
		for(int i=0;i<airlineNumbers.size();i++)
		{
			String airline = airlineNumbers.get(i).getText();
			String departureTime = departureTimes.get(i).getText();
			String fare = fares.get(i).getText();
			
			int amount = Integer.parseInt(fare);

			if(amount < 5000)
			{
				temp = new ArrayList<String>();
				temp.add(airline);
				temp.add(departureTime);
				temp.add(fare);
				
				airlineDetails.add(temp);
			}
		}
		
		for(int i=0;i<airlineDetails.size();i++)
		{
			System.out.println("Flight "+(i+1)+":");
			System.out.println("Flight Name: "+airlineDetails.get(i).get(0));
			System.out.println("Departure Time: "+airlineDetails.get(i).get(1));
			System.out.println("Fare: "+airlineDetails.get(i).get(2));
			System.out.print("\n");
		}
		
	}
	
}
