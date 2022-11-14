package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;

public class CaStore {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\X022654\\\\OneDrive - Thomson Reuters Incorporated\\\\Desktop\\\\chrome_driver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String Search_key="family law";
		driver.manage().window().maximize();
		driver.get("https://ams_uat:AMS_65uat@store-tr-ca-uat-ams.ewp.thomsonreuters.com/en-ca/home");
		//driver.get("https://store.thomsonreuters.ca/en-ca/home");
		//driver.get("https://store.thomsonreuters.ca/fr-ca/home");
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
		driver.navigate().to("https://ams_uat:AMS_65uat@store-tr-ca-uat-ams.ewp.thomsonreuters.com/en-ca/cart");
		//driver.navigate().to("https://store.thomsonreuters.ca/en-ca/cart");
		//driver.navigate().to("https://store.thomsonreiters.ca/fr-ca/cart");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='tr-Svg-inner'])[14]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='promoCodeInput']")).sendKeys("1OFF");
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
		driver.findElement(By.xpath("//strong[normalize-space()='Free standard shipping']")).click();
		driver.findElement(By.xpath("//button[@class='tr-Anchor tr-Button tr-Button--primary tr-Button--semiCircular']")).click();
		Thread.sleep(3000);
		/*driver.findElement(By.xpath("//label[@for='isSameAsShipping']//span[@class='tr-FormCheckboxControl-labelText']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//input[@id='searchInput-9'])[1]")).sendKeys("can");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[normalize-space()=\"Canada, ON, Vaughan, Maple, Canada's wonderland dr\"])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='billingPostalCode']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='billingPostalCode']")).sendKeys("A1A 1A1");*/
		driver.switchTo().frame("CREDIT_CARD_IFRAME_ID");
		driver.findElement(By.xpath("//*[contains(text(),'Name on card')]//following::input[1]")).sendKeys("Test");
		driver.findElement(By.xpath("//*[contains(text(),'Card number')]//following::input[1]")).sendKeys("4114360123456785");
		WebElement month = driver.findElement(By.id("selectCardMonth"));
		Select month_card = new Select(month);
		month_card.selectByIndex(5);
		WebElement year = driver.findElement(By.id("selectCardYear"));
		Select year_card = new Select(year);
		year_card.selectByIndex(6);
		driver.findElement(By.id("SecurityCode")).sendKeys("123");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[normalize-space()='I authorize payment']")).click();
		driver.findElement(By.xpath("//button[contains(@data-testid,'checkout_btn')]")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		Thread.sleep(20000);
		print(driver.findElement(By.xpath("//span[@class='tr-OrderConfirmation-normalText tr-Typography tr-Typography--xxs tr-Typography--left']")).getText());
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
