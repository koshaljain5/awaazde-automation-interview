package MainPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MoisturizersPage extends BaseClass{
	
	public int AddMoisturizertoCart()
	{
		
		List<WebElement> aloe = driver.findElements(By.xpath("//p[contains(text(),'Aloe')]/following-sibling::p"));
		List<WebElement> almond = driver.findElements(By.xpath("//p[contains(text(),'Almond')]/following-sibling::p"));
		
		int price1 = sortarray(aloe);
		WebElement ele50 =  driver.findElement(By.xpath("//p[contains(text(),'Aloe')]/following-sibling::p[contains(text(),'"+price1+"')]/following-sibling::button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele50);
		ele50.click();
		
		int price2 = sortarray(almond);
		WebElement ele30 =  driver.findElement(By.xpath("//p[contains(text(),'Almond')]/following-sibling::p[contains(text(),'"+price2+"')]/following-sibling::button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele30);
		ele30.click();
		
		driver.findElement(By.xpath("//button[@onclick='goToCart()']")).click();
		
		return price1+price2;
	}

}
