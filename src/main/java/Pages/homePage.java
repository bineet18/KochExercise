package Pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import properties.initializeTestData;
import properties.initializeXpaths;

public class homePage extends initializeXpaths
{
	WebDriver driver;
	Properties propX, propT;
    public homePage(WebDriver driver) throws IOException 
    {
    	this.driver = driver;
		this.propX = super.propX;
		
		initializeTestData t = new initializeTestData();
		propT = t.returnTestData();
	}

	public void enterSourceCity() throws InterruptedException
    {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		WebElement fromClear;
		fromClear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(propX.getProperty("fromClear"))));
		fromClear.click();
		

		String fromStation = propT.getProperty("from");
		WebElement from = driver.findElement(By.xpath(propX.getProperty("from"))); 
		for(int i=0;i<fromStation.length();i++)
		{
			from.sendKeys( Character.toString(fromStation.charAt(i)));
			
			Thread.sleep(300);
			if(i==fromStation.length()-1)
			{from.sendKeys(Keys.ENTER);}
		}
   }
	
	public void enterDestinationCity() throws InterruptedException
    {
		String toStation = propT.getProperty("to");
		WebElement to = driver.findElement(By.xpath(propX.getProperty("to"))); 
		for(int i=0;i<toStation.length();i++)
		{
			to.sendKeys( Character.toString(toStation.charAt(i)));
			
			Thread.sleep(300);
			if(i==toStation.length()-1)
			{to.sendKeys(Keys.ENTER);}
		}
    }
	
	public void selectDepartureDate()
	{
		WebElement departureDate = driver.findElement(By.xpath(propX.getProperty("departureDate")
				+propT.getProperty("departureDay")+propT.getProperty("departureMonth")
				+propT.getProperty("departureYear")+"']"));
		departureDate.click();
	}
	
	public void selectReturnDate()
	{
		WebElement calender = driver.findElement(By.xpath(propX.getProperty("returnCalender")));
		calender.click();		
		
		WebElement returnDate = driver.findElement(By.xpath(propX.getProperty("returnDate")
				+propT.getProperty("returnDay")+propT.getProperty("returnMonth")
				+propT.getProperty("returnYear")+"'])[2]"));
		returnDate.click();
	}
	
	public void selectTravellers() throws InterruptedException
	{
		WebElement travellerSelector = driver.findElement(By.xpath(propX.getProperty("travellerSelector")));
		travellerSelector.click();
		
		WebElement adultTraveller = driver.findElement(By.xpath("("+propX.getProperty("adultTraveller")
				+")["+propT.getProperty("adultTraveller")+"]"));
		adultTraveller.click();
		
	}
	
	public void search()
	{
		WebElement search = driver.findElement(By.xpath(propX.getProperty("search")));
		search.click();
	}
	
}
