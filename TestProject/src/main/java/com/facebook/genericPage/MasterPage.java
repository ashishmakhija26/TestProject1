package com.facebook.genericPage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MasterPage {

	public static WebDriver driver;
	public Properties prop;
	public Properties or;
	public Properties td;

	// Constructor Implementation
	public MasterPage() throws Exception {
		// configuration properties file implementation
		FileInputStream ip = new FileInputStream(
				".\\src\\main\\java\\com\\facebook\\repository\\configuration.properties");
		prop = new Properties();
		prop.load(ip);

		// locators properties file implementation
		FileInputStream fs = new FileInputStream(".\\src\\main\\java\\com\\facebook\\repository\\locators.properties");
		or = new Properties();
		or.load(fs);

		// testdata properties file implementation
		FileInputStream ts = new FileInputStream(".\\src\\main\\java\\com\\facebook\\repository\\testdata.properties");
		td = new Properties();
		td.load(ts);

		// Added latest WebDriverManager Dependency (5.3.1) into pom.xml file
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		if (prop.getProperty("browser").equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		else if (prop.getProperty("browser").equalsIgnoreCase("chromes__")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + ".\\src\\main\\java\\com.facebook.drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else {
			System.out.println("No Browser Details Found");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
