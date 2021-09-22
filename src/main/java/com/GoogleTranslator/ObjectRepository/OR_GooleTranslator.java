package com.GoogleTranslator.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.GoogleTranslator.FunctionalLibrary.FunctionalLibrary;

//Getting the xpath using @FindBy method
public class OR_GooleTranslator extends FunctionalLibrary{
	

	
	public OR_GooleTranslator(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="(//div[contains(@class,'akczyd')]/descendant::div[@jsname='HexNre']/descendant::span[text()='English'])[1]/parent::span/parent::button")
	protected WebElement btn_selectEnglish;
	
	@FindBy(xpath="(//div[contains(@class,'akczyd')]/descendant::div[@jsname='ji7Qmb']/descendant::span[text()='Spanish'])[1]/parent::span/parent::button")
	protected WebElement btn_selectSpanish;
	
	@FindBy(xpath="//div[@class='QFw9Te']/textarea")
	protected WebElement txtBox_textArea;
	
	@FindBy(xpath="//div[contains(@class,'J0lOec')]/descendant::span[@jsname='W297wb']")
	protected WebElement txtBox_OutputTextArea;
	
}
