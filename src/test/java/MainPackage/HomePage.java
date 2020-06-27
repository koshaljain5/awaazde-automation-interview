package MainPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;


public class HomePage extends BaseClass{

	
	public int taketemperature()
	{
		int temp = 0;
		try 
		{
			temp = Integer.parseInt(driver.findElement(By.xpath("//span[@id='temperature']")).getText().split(" ")[0]);
		}
		catch (Exception e) {
			System.out.println("Exception Occurred in taketemperature");
		}
		return temp;
		
	}
	
	public String homeShopOption()
	{
		String option = "";
		int temp = taketemperature();
		if(temp<=19)
			option = "moisturizer";
		else
			option = "sunscreen";
		
		driver.findElement(By.xpath("//a[contains(@href,'"+option+"')]/button")).click();
		System.out.println("Clicked on: "+option);
		return option;
	}
	
}
