import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class example {

	public static void main(String[] args) {
       try {
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to("https://www.diatoz.com");
			Thread.sleep(3000);
			
			String actualUrl = "https://www.diatoz.com/";
			String expectedUrl = driver.getCurrentUrl();
			System.out.println("Url of the page : "+expectedUrl);
			Assert.assertEquals(actualUrl,expectedUrl);
			
			String actualTitle = "DIATOZ";
			String expectedTitle = driver.getTitle();
			System.out.println("Title of the page : "+expectedTitle);
			Assert.assertEquals(actualTitle, expectedTitle);
			
			WebElement e = driver.findElement(By.xpath("//*[@id=\"banner\"]/h1"));
			String Text = e.getText();
			System.out.println(Text);
			Thread.sleep(2000);
			
			WebElement services = driver.findElement(By.xpath("//*[@id=\"navbar_main\"]/div/ul/li[1]/a"));
	        WebElement product = driver.findElement(By.xpath("//*[@id=\"navbar_main\"]/div/ul/li[1]/div/span[3]/a"));
	        Actions a = new Actions(driver);
	        a.moveToElement(services).perform();
	        Thread.sleep(2000);
	        
	        a.moveToElement(product).perform();
	        Thread.sleep(2000);
	        
	        a.click().perform();
	        Thread.sleep(4000);
	        
	        String aUrl = "https://www.diatoz.com/services/product-innovation";
	        String eUrl = driver.getCurrentUrl();
	        System.out.println("Url of the page : "+eUrl);
	        Assert.assertEquals(aUrl, eUrl);
	        
	        
	        driver.navigate().back();
	        Thread.sleep(4000);
	        String Url = driver.getCurrentUrl();
	        System.out.println("Url of the page : "+Url);
	        
	        JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	        Thread.sleep(2000);
	        
	        driver.findElement(By.name("email")).sendKeys("vilasarun11@gmail.com");
	        Thread.sleep(2000);
	        
	        WebElement contactUs = driver.findElement(By.xpath("//*[@id=\"navbar_main\"]/div/ul/li[7]/a"));
	        a.moveToElement(contactUs).click().perform();
	        Thread.sleep(2000);
	        
	        js.executeScript("window.scrollBy(0,700)","");
	        Thread.sleep(2000);
	        
	        driver.findElement(By.name("name")).sendKeys("Vilas");
	        Thread.sleep(2000);
	        
	        driver.findElement(By.name("contact")).sendKeys("8867991141");
	        Thread.sleep(2000);
	        
	        driver.findElement(By.name("email")).sendKeys("vilasarun11@gmail.com");
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Need Estimation of total cost of the project.");
	        Thread.sleep(2000);
	        
	        js.executeScript("window.scrollBy(0,500)","");
	        Thread.sleep(2000);
	        
	        WebElement con1 = driver.findElement(By.xpath("//button[@class='btn word-wide-offices-btn active']"));
	        con1.click();
	        Thread.sleep(2000);
	        String expectedCountry1 = "India";
	        String actualCountry1 = con1.getText();
	        Assert.assertEquals(expectedCountry1, actualCountry1);
	         
	        WebElement con2 = driver.findElement(By.xpath("(//button[@class='btn word-wide-offices-btn '])[1]"));
	        con2.click();
	        Thread.sleep(2000);
	        String expectedCountry2 = "Singapore";
	        String actualCountry2 = con2.getText();
	        Assert.assertEquals(expectedCountry2, actualCountry2);
	        
	        WebElement con3 = driver.findElement(By.xpath("(//button[@class='btn word-wide-offices-btn '])[2]"));
	        con3.click();
	        Thread.sleep(2000);
	        String expectedCountry3 = "United States";
	        String actualCountry3 = con3.getText();
	        Assert.assertEquals(expectedCountry3, actualCountry3);
	        
	        a.moveToElement(contactUs).click().perform();
	        Thread.sleep(2000);
	        
	        for(int i=1;i<=3;i++) {
	        	driver.navigate().refresh();
		        Thread.sleep(2000);
	        }
	       
	        driver.quit();
	        
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
