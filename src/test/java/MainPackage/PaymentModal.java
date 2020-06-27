package MainPackage;

import org.openqa.selenium.By;

public class PaymentModal extends BaseClass {
	
	public void finalpayment()
	{
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.switchTo().frame("stripe_checkout_app");
		if(driver.findElements(By.xpath("//input[@type='email']")).size()>0)
		{
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys("koshaljain5@gmail.com");
			driver.findElement(By.xpath("//input[@placeholder='Card number']")).sendKeys("4242424242424242");
			driver.findElement(By.xpath("//input[@placeholder='MM / YY']")).sendKeys("0121");
			driver.findElement(By.xpath("//input[@placeholder='CVC']")).sendKeys("123");
			driver.findElement(By.xpath("//input[@placeholder='ZIP Code']")).sendKeys("123456");
			driver.findElement(By.xpath("//div[@class = 'Section-button']/button[@type='submit']")).click();
			System.out.println("Successfully Entered Card Details on stripe.com");
			driver.switchTo().parentFrame();
		}
		else
			System.out.println("Payment Model Not Found");
	}
}
