package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRTCRail {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	    driver.findElement(By.xpath("//a[contains(text(),' FLIGHTS ')]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String> list=new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getCurrentUrl());

	     driver.findElement(By.xpath("//button[text()='Allow']")).click();
	     driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
	     String text = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[3]")).getText();
	     System.out.println(text);
		
	}

}
