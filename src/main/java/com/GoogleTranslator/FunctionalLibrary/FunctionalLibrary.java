//Author: Manikandan K.

package com.GoogleTranslator.FunctionalLibrary;

import java.util.NoSuchElementException;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//Creating wrapper methods

public class FunctionalLibrary {

	public WebDriver driver;
	String browser;
	int timeOut=30;
	public FunctionalLibrary(WebDriver driver) {
		this.driver = driver;
	}


	public void clickUsingJS(WebElement we) throws Exception {
		try {
			
			if (we != null) {
				((JavascriptExecutor) driver).executeScript("aruguments[0].click();", we);
			}
		} catch (Exception e) {

		}
	}
	protected void setText(WebElement element,String value)throws InterruptedException{
		try{
			if(isDisplayed(element)){
				element.sendKeys(value);
			}
			else{
				throw new Exception("Element not found for SetText");
			}
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	protected void click(WebElement element)throws Exception{
		try{
			new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception e){
			throw new Exception("Click failed for element in page");
		}
		element.click();
	}
	
	protected void clearText(WebElement element)throws Exception{
		try{
			new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception e){
			throw new Exception("Click failed for element in page");
		}
		element.click();
		element.clear();
	}
	
	protected boolean isDisplayed(WebElement element){
		try{
			new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element));
			System.out.println("The Object identifiaction completed for the element "+element);
			return element.isDisplayed();
		}
		catch(TimeoutException e){
			System.out.println("The Object identifiaction Failed for the element "+element+" due to TimeoutException");
			return false;
		}
		catch(ElementNotVisibleException e) {
			System.out.println("The Object identifiaction Failed for the element "+element+" due to ElementNotVisibleException");
			return false;
		}
		catch(NoSuchElementException e){
			System.out.println("The Object identifiaction Failed for the element "+element+" due to NoSuchElementException");
			return false;
		}		
	}
	protected String getAttribute(WebElement element,String propertyName){
		try {
			return element.getAttribute(propertyName);
		}catch (Exception e) {
			return "Object Not Found No value is  retrived";
		}
	}
}
