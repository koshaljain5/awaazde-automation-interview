package MainPackage;

import org.openqa.selenium.By;

public class CheckoutPage extends BaseClass {

	
	public int checkout()
	{
		if(driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr")).size() == 2)
			System.out.println("Successfully Selected 2 Items in Cart");
		else
			System.out.println("Failed to Select 2 Items in Cart");

		int total = Integer.parseInt(driver.findElement(By.xpath("//p[@id='total']")).getText().split(" ")[2]);
		return total;
	}
	
	public boolean verifyPaymentSuccess()
	{
		Boolean flag = false;
		if(driver.findElements(By.xpath("//h2[text()='PAYMENT SUCCESS']")).size()>0)
			flag = true;
		else
			flag = false;
		
		return flag;
	}
}
