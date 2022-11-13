import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Invoking Browser
		//Chrome -> ChromeDriver -> Methods
		
		// Chrome
		System.setProperty("webdriver.chrome.driver", "E:\\study-meterial\\myStudy\\Language\\Java\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();



		//Firefox
		//System.setProperty("webdriver.gecko.driver", "/Users/rahulshetty/Documents/geckodriver");
		//WebDriver driver1 = new FirefoxDriver();

		//Microsoft Edge
		//System.setProperty("webdriver.edge.driver", "/Users/rahulshetty/Documents/msedgedriver");
		//WebDriver driver2 = new EdgeDriver();
		

		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();

		//driver.quit();//It close all associate windows
	}

}
