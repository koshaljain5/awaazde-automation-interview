package MainPackage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class BaseClass {

	static WebDriver driver = null;
	
	public void setUP()
	{
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		System.setProperty("webdriver.chrome.driver", "D:/Koshal-Practice/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://weathershopper.pythonanywhere.com/");
	}
	
	public int sortarray(List<WebElement> spf50)
	{
		int[] intArray = new int[spf50.size()];

		for (int i=0;i<spf50.size();i++) 
		{ 
			intArray[i] = Integer.parseInt(spf50.get(i).getText().split(" ")[spf50.get(i).getText().split(" ").length-1]);
		}
		Arrays.sort(intArray);
		return intArray[0];
	}
	
	public void quitdriver()
	{
		driver.quit();
	}
	
}
