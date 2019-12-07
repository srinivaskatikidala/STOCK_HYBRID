package Dummy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CommonFunLibrary.FunctionLibrary;

public class ExtentDemo {
 static WebDriver driver;
	
 public static void main(String[] args) {
    
		
		System.setProperty("webdriver.chrome.driver","D:\\Nivas.sri\\Automation\\Stock_Accounting\\CommonJars\\chromedriver.exe");
		driver = new ChromeDriver();
		
		ExtentReports report =	new ExtentReports("C:\\Users\\srinivas.k\\Desktop\\extentdemo.html");
		ExtentTest test= report.startTest("Name of Test");
		
				driver.get("http://primusbank.qedgetech.com/");
		test.log(LogStatus.INFO, "Application opened successfully");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		
		test.log(LogStatus.INFO, "sent name");
				
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		test.log(LogStatus.INFO, "sent pword");
		
		driver.findElement(By.id("login")).click();
		test.log(LogStatus.INFO, "Enter login");
		
		report.endTest(test);
		report.flush();
	}
	

}
