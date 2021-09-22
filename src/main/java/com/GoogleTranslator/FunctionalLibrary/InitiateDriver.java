package com.GoogleTranslator.FunctionalLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitiateDriver {
	String browser;
	public WebDriver driver;
	
	//Initiate browser
	public InitiateDriver(String browser) {
		this.browser = browser;
	}
	
	//Launching browser
	public void launchBrowser(String url) {
		browser = browser.toLowerCase();
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			this.driver.get(url);
		}
	}
	
	//Returning the object of WebDriver
	public WebDriver getDriver() {
		return this.driver;
	}
	
}	
