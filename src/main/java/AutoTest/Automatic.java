package AutoTest;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Automatic {
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\may.z.zhu\\eclipse-workspace\\mavenweb\\src\\main\\resources\\drivers\\chromedriver.exe");
	WebDriver driver=new ChromeDriver(setChromeOptions());
	
	
	
	//Xpath定位
	driver.get("https://mb-frontend-olss-d0.osc1.ct1.cathaypacific.com/#/en_HK/login");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//设置等待时间
	driver.findElement(By.xpath("//input[contains(@id,'familyName')]")).sendKeys("zzz");
	
	//id定位
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//
	driver.findElement(By.id("givenName")).clear();
	driver.findElement(By.id("givenName")).sendKeys("may");
	
	//css定位-通配符，使用逻辑运算符
	//driver.findElement(By.cssSelector("[class^=ed]")).sendKeys("10111");
	//css定位-通过属性定位
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.cssSelector("[id=rloc-and-eticket]")).sendKeys("1211");

	//class定位
	driver.findElement(By.className("button-title")).click();
	driver.close();
	
	try {
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
	
}
	public static ChromeOptions setChromeOptions() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-web-security");
		return options;
	} 
}

