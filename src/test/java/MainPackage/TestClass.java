package MainPackage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass{
	
	BaseClass base = new BaseClass();
	HomePage home = new HomePage();
	CheckoutPage checkout = new CheckoutPage();
	MoisturizersPage Moist = new MoisturizersPage();
	SunscreenPage Sunscrn = new SunscreenPage();
	PaymentModal payment = new PaymentModal();
	
	@BeforeTest
	public void launchWeb()
	{
		base.setUP();
	}

	@Test
	public void ShopFlow()
	{
		try
		{
			String Option = home.homeShopOption();
			int totalprice = 0;
			if(Option.equals("moisturizer"))
				totalprice = Moist.AddMoisturizertoCart();
			else if(Option.equals("sunscreen"))
				totalprice= Sunscrn.AddSunscreentoCart();
			else
				System.out.println("No Selection Option Found on Home Page");
			
			if(totalprice == checkout.checkout())
				System.out.println("Correct Total Price on Checkout Page: "+totalprice);
			else
				System.out.println("Wrong Total Price on Checkout Page: "+checkout.checkout());
			
			payment.finalpayment();
			
			if(checkout.verifyPaymentSuccess())
				System.out.println("Payment Successful");
			else
				System.out.println("Payment Failed");
		}
		catch(Exception e)
		{
			System.out.println("Test Failed: Some Exception Occurred:" + e.toString());
		}
	}
	
	@AfterTest
	public void teardown()
	{
		base.quitdriver();
	}
}
