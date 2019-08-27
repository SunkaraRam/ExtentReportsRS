package ReportsRS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

public class Orange {

	Logger log;
	
	WebDriver driver;
	
	ExtentReports report;
	
	ExtentTest test;
	
	@BeforeTest
	public void generate() {
	
		report = new ExtentReports("d://myfile88996.html");
		
		test = report.startTest("Reporting");
		
		test.assignAuthor("RamSunkara");
		
		test.assignCategory("Regression");
		
	}

	public void Verify_Login() {
		
		test = report.startTest("Login");
		
		log = Logger.getLogger(getClass());
		
		//Pr000opertyConfigurator
		System.setProperty("webdriver.chrome.driver", "d://chromedriver.exe");
		
		driver = new ChromeDriver();
		
		log.info("launching chrome browser");
		
		driver.get("http://orangehrm.qedgetech.com");
		
		log.info("launching url : " + driver.getCurrentUrl());
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		
		log.info("Enter username");
		
		driver.findElement(By.name("txtPassword")).sendKeys("Admin");
		
		log.info("Enter Password");
		
		driver.findElement(By.name("Submit")).click();
		
		log.info("Click on login");
		
		
		String expval = driver.getCurrentUrl();
		
		String actval = "dash";
		
		if (expval.contains(actval)) {
			
			test.log(LogStatus.PASS, "Login success::"+expval+" "+actval);
			Reporter.log("Login Success");
			log.info("LoginSuccess::"+expval+" "+actval);
			
		}
		
		else {
			
			String message=driver.findElement(By.id("spanMessage")).getText();
			test.log(LogStatus.FAIL, "Login Unsuccess::"+message);
			Reporter.log("Login Unsuccess");
			log.info("Login Unsuccess::"+expval+"    "+actval);	
			
		}
		driver.close();
	}
	@AfterTest
	
	public void logout() {
		
		report.flush();
		
		report.endTest(test);
		
	}
		
		
		
	}


