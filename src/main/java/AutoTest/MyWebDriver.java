package AutoTest;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class MyWebDriver {
	
	private static Properties p;
//	
//	public MyWebDriver() {
//		this.p=new Properties();
//		try {s
//			FileInputStream is=new FileInputStream(Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "iptest.properties").toString());
//			p.load(is);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//		System.out.println(p);
//	}
	
	public static WebDriver initBrowser(String browserType) throws MalformedURLException {
		
		WebDriver driver = null;
		switch (browserType) {
		case "firefox":
			System.setProperty(p.getProperty("firefox_type"),p.getProperty("firefox_bin"));
	        driver=new FirefoxDriver();
			break;
		case "ie":
			 System.setProperty(p.getProperty("ie_type"),p.getProperty("ie_bin"));
			 driver=new InternetExplorerDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver","C:\\Users\\may.z.zhu\\eclipse-workspace\\mavenweb\\src\\main\\resources\\drivers\\chromedriver.exe");
		    driver=new ChromeDriver();
			break;
		case "RemoteWebDriver":
			p.getProperty("remotedriver_type");
	        driver=new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), DesiredCapabilities.chrome());
			break;
			default:
				try {
					throw new Exception("浏览器错误");
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		driver.get("https://cn.bing.com");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();//最大化屏幕•
// 		driver.close();		
		return driver;
	}
}




