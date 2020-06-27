package MainPackage;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class SunscreenPage extends BaseClass {

	public int  AddSunscreentoCart()
	{
		List<WebElement> spf50 = driver.findElements(By.xpath("//p[contains(text(),'SPF-50')]/following-sibling::p"));
		List<WebElement> spf30 = driver.findElements(By.xpath("//p[contains(text(),'SPF-30')]/following-sibling::p"));

		int price1 = sortarray(spf50);
		WebElement ele50 =  driver.findElement(By.xpath("//p[contains(text(),'SPF-50')]/following-sibling::p[contains(text(),'"+price1+"')]/following-sibling::button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele50);
		ele50.click();
		
		int price2 = sortarray(spf30);
		WebElement ele30 =  driver.findElement(By.xpath("//p[contains(text(),'SPF-30')]/following-sibling::p[contains(text(),'"+price2+"')]/following-sibling::button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele30);
		ele30.click();
		
		driver.findElement(By.xpath("//button[@onclick='goToCart()']")).click();
		
		return price1+price2;
	}


	
}
