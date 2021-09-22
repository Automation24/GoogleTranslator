package com.GoogleTranslator.Pages;

import java.util.HashMap;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.GoogleTranslator.ObjectRepository.OR_GooleTranslator;
import com.GoogleTranslator.Utlities.ExcelComplete;


public class Pages_GoogleTranslator extends OR_GooleTranslator{
	WebDriver driver;
	ExcelComplete excel = new ExcelComplete();
	public Pages_GoogleTranslator(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	//Method to select the language
	public void clickLanguage() {
		try {
			if(isDisplayed(btn_selectEnglish))
				click(btn_selectEnglish);
			if(isDisplayed(btn_selectSpanish))
				click(btn_selectSpanish);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Validating the translated word
	public void validateTranslate(HashMap<String,String> data) {
		try {
			if(isDisplayed(txtBox_textArea)) {
				click(txtBox_textArea);
				setText(txtBox_textArea, data.get("TestData"));
				txtBox_textArea.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				String actual=getAttribute(txtBox_OutputTextArea, "textContent");
				
				//writing the values into the excel sheet and update the status as passed/failed based on the result
				if(data.get("Expected").trim().equals(actual)) {
					excel.writeData("./TestData/Selenium.xlsx", "Sheet1", "TestData", data.get("TestData"), actual, "Actual");
					excel.writeData("./TestData/Selenium.xlsx", "Sheet1", "TestData", data.get("TestData"), "Passed", "Result");
				}
				else {
					excel.writeData("./TestData/Selenium.xlsx", "Sheet1", "TestData", data.get("TestData"), actual, "Actual");
					excel.writeData("./TestData/Selenium.xlsx", "Sheet1", "TestData", data.get("TestData"), "Failed", "Result");
				}
			}
			clearText(txtBox_textArea);
			Thread.sleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
