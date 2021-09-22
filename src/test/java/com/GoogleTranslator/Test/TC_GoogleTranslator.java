//Author: Manikandan Krishnamoorthy

package com.GoogleTranslator.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GoogleTranslator.FunctionalLibrary.FunctionalLibrary;
import com.GoogleTranslator.FunctionalLibrary.InitiateDriver;
import com.GoogleTranslator.Pages.Pages_GoogleTranslator;
import com.GoogleTranslator.Utlities.ExcelComplete;

//Google Translator Testcase
public class TC_GoogleTranslator {
	
	WebDriver driver;
	InitiateDriver iDriver;
	@Test
	public void test() throws Exception{
		try {
			iDriver = new InitiateDriver("chrome");
			iDriver.launchBrowser("https://translate.google.com/");
			driver = iDriver.getDriver();
			
			//Selecting the English and Spanish as per the requirement
			Pages_GoogleTranslator page = new Pages_GoogleTranslator(driver);
			page.clickLanguage();
			
			//Reading the values from the excel and validating the translated value
			ArrayList<HashMap<String, String>> arrHashMap = new ArrayList<HashMap<String, String>>();
			ExcelComplete excel = new ExcelComplete();
			arrHashMap = excel.readExcel("./TestData/Selenium.xlsx", "Sheet1");
			for(HashMap<String,String> map:arrHashMap) {
				page.validateTranslate(map);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			driver.close();
		}
	}
	
}
