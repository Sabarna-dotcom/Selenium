import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;

public class CaStore {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\study-meterial\\myStudy\\Language\\Java\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String Search_key="family law";
		driver.manage().window().maximize();
		driver.get("https://store.thomsonreuters.ca/en-ca/home");
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@class='tr-Button-body']")).click();
		Thread.sleep(5000);
		String book1=add_to_cart(driver);
		driver.findElement(By.xpath("//div[@class='magic-box-input']/input")).sendKeys(Search_key);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='coveo-search-button']//*[name()='svg']")).click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='tr-coveo-results-highlight']/span")).getText(),Search_key);
		String book2=add_to_cart(driver);
		driver.navigate().to("https://store.thomsonreuters.ca/en-ca/cart");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='tr-Svg-inner'])[14]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='promoCodeInput']")).sendKeys("10OFF");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='tr-Anchor tr-Button tr-Button--primary']")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//body//div//div[@role='region']//div//div//div//div//div//div//div//div//div//div//div//span//span[1]")).getText(),"We couldn't find a promotion matching your code. Verify your information and try again.");
		driver.findElement(By.xpath("//div[@class='tr-OrderSummaryCart-checkOutButton']/button")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='tr-LoginPopup-guestLoginButton']/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Test first name");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Test last name");
		driver.findElement(By.xpath("//input[@id='businessEmailAddress']")).sendKeys("test@gmail.com");
		WebElement org_dropdown = driver.findElement(By.xpath("//select[@id='typeOfOrganization']"));
		Select dropdown = new Select(org_dropdown);
		dropdown.selectByIndex(1);
		driver.findElement(By.xpath("//input[@id='organizationName']")).sendKeys("Test");
		driver.findElement(By.xpath("//button[@class='tr-Anchor tr-Button tr-Button--primary tr-Button--circular']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[@id='searchInput-5'])[1]")).sendKeys("240");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@id='searchInput-5-typeaheadItem-0']/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='phoneNumber']")).sendKeys("9090909090");
		Thread.sleep(3000);
		WebElement radio1 = driver.findElement(By.xpath("(//input[@id='freeShipping'])[1]"));
		radio1.click();
		Thread.sleep(5000);
		driver.close();
		print("Success");

	}
	
	public static void print(String str) {
		System.out.println(str);
	}
	
	public static String add_to_cart(WebDriver driver) throws InterruptedException {
		
		String book1=driver.findElement(By.xpath("//body/div[@id='root']/div[@class='root responsivegrid']/div[@class='aem-Grid aem-Grid--12 aem-Grid--default--12 ']/div[@class='responsivegrid aem-GridColumn aem-GridColumn--default--12']/div[@class='aem-Grid aem-Grid--12 aem-Grid--default--12 ']/div[@class='responsivegrid aem-GridColumn aem-GridColumn--default--12']/div[@class='aem-Grid aem-Grid--12 aem-Grid--default--12 ']/div[@class='section aem-GridColumn aem-GridColumn--default--12']/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[5]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/a")).getText();
		driver.findElement(By.xpath("//body/div[@id='root']/div[@class='root responsivegrid']/div[@class='aem-Grid aem-Grid--12 aem-Grid--default--12 ']/div[@class='responsivegrid aem-GridColumn aem-GridColumn--default--12']/div[@class='aem-Grid aem-Grid--12 aem-Grid--default--12 ']/div[@class='responsivegrid aem-GridColumn aem-GridColumn--default--12']/div[@class='aem-Grid aem-Grid--12 aem-Grid--default--12 ']/div[@class='section aem-GridColumn aem-GridColumn--default--12']/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[5]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/a")).click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.cssSelector("h1[class='tr-Heading tr-Heading--m'] strong")).getText(),book1);
		for(int i=1;i<5;i++) {
			driver.findElement(By.xpath("//button[normalize-space()='+']")).click();
			Thread.sleep(100);
		}
		driver.findElement(By.xpath("//div[@class='tr-ProductPricing-addToCartBtn']/button/span")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.cssSelector("h1[class='tr-Heading tr-Heading--m'] strong")).getText(),book1);
		return book1;
	}
	

}
