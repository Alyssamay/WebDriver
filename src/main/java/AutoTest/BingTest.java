package AutoTest;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BingTest {
	public static void main(String args[]) throws InterruptedException {
		Properties p=new Properties();
		try {
			FileInputStream is=new FileInputStream(Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "iptest.properties").toString());
			p.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	    //System.out.println(p);
		
		String path=p.getProperty("readText_path");
		String browserType =p.getProperty("browserType");
		WebDriver driver = null;
		
		try {
			driver = MyWebDriver.initBrowser(browserType);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		WebElement queryInputElement =driver.findElement(By.xpath("//input[@id='sb_form_q']"));//æ�œç´¢å…³é”®å­—
		//String s = Data.readTextToList(".\\src\\main\\resources\\Data_searchbox").get(0); //list
		String s=Data.readText(path).pop();//stack
		queryInputElement.sendKeys(s);
		WebElement submitBtnElement=driver.findElement(By.className("b_searchboxSubmit"));
		submitBtnElement.click();
		
		WebElement ele=driver.findElement(By.linkText("Images"));//æ–­è¨€searchResult pageæ–‡å­—é“¾æŽ¥Imageså…ƒç´ æ˜¯å�¦å­˜åœ¨
		assertTrue(ele.isDisplayed());
		
		try {
			driver.findElement(By.xpath("//div[contains(@class,'shader_left')]"));
			//åœ¨searchResulté¡µé�¢æ‰¾homepageå…ƒç´ æ—¶æŠ›å¼‚å¸¸Â¸
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception
		}
	
		WebElement resultNum=driver.findElement(By.xpath("//span[@class='sb_count']"));//æ‰“å�°æ£€ç´¢çš„Result Number
		String info=resultNum.getText();
		info=(info.substring(0, 10)).replaceAll(",","");
		System.out.println(info);
		int Result1=Integer.parseInt(info);
		
	    
		//a[contains(text(),'Past 24 hours')]
	    driver.findElement(By.xpath("//span[@class='fs_label']")).click();
	    driver.findElement(By.linkText("Past 24 hours")).click();
	   
	   
	    WebElement resultNum2=driver.findElement(By.xpath("//span[@class='sb_count']"));
		String info2=resultNum2.getText();
		info2=info2.substring(0, 2);
		System.out.println(info2);
		int Result2=Integer.parseInt(info2);
		
		
	    if(Result2<Result1) {
	    	System.out.println("CompareResult is true");//æ¯”è¾ƒæ£€ç´¢çš„ç»“æžœ
	    }
	    else {
	    	System.out.println("CompareResult is false");
		}
		
	  driver.close();	
	 
		
	}

}
