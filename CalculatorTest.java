package test.java;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
	
	WebDriver driver;
	
	@BeforeEach
	public void setup() {
		
		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver",System.getenv("CHROME_WEB_DRIVER_PATH"));
	      
		// Instantiate a ChromeDriver class.       
		driver = new ChromeDriver();
	    	    
		// Launch Website  
		driver.navigate().to("https://nuix.github.io/SDET/senior-sdet/stagingCalc/index.html"); 
		//driver.navigate().to("https://nuix.github.io/SDET/senior-sdet/productionCalc/index.html"); 
          
		//Maximize the browser  
		driver.manage().window().maximize(); 

		//start tests after a brief wait for page to render
		delay(1000);
		
	}
	
	@AfterEach
	public void tearDown() {
		driver.close();
	}

	@Test
	void additionTestIntegers() {
		
		//logger to go here
		System.out.println("ADD INTEGER TEST");
		
		int expectedValue;
		
		for(int i = 0; i <= 9; i++) {
			
			String numberOne = "input[value='" + i + "']";
			
			for(int j = 0; j <= 9; j++) {
				
				expectedValue = i + j;
				findElementByCssAndClick(numberOne);
				findElementByIdAndClick("add");
				
				String numberTwo = "input[value='" + j + "']";
				findElementByCssAndClick(numberTwo);
				
				findElementByCssAndClick("input[value='=']");
				
				delay(100);
				
				String actualValueText = driver.findElement(By.id("display")).findElement(By.xpath("//div")).getText();
				 
				int actualValue;
				
				try {
					actualValue = Integer.parseInt(actualValueText);
				}
				catch (NumberFormatException e)
				{
					actualValue = 0;
				}
				
				//loggers would go here
				
				System.out.println("i: " + i + " j: " + j);
				System.out.println("expectedValue: " + expectedValue + " actualValue: " + actualValue);
				
				assertEquals(expectedValue,actualValue);
				
				findElementByCssAndClick("input[value='C']");
				
				delay(100);
				
			}
		}
		
	}
	
	@Test
	void additionTestDecimals() {

		//logger to go here
		System.out.println("ADD DECIMAL TEST");
		
		float expectedValue = 8.43f;
		
		findElementByCssAndClick("input[value='6']");
		findElementByCssAndClick("input[value='.']");
		findElementByCssAndClick("input[value='1']");
		findElementByCssAndClick("input[value='7']");

		findElementByIdAndClick("add");
		
		findElementByCssAndClick("input[value='2']");
		findElementByCssAndClick("input[value='.']");
		findElementByCssAndClick("input[value='2']");
		findElementByCssAndClick("input[value='6']");
				
		findElementByCssAndClick("input[value='=']");
		
		delay(100);
		
		String actualValueText = driver.findElement(By.id("display")).findElement(By.xpath("//div")).getText();
		 
		float actualValue;
		
		try {
			actualValue = Float.parseFloat(actualValueText);
		}
		catch (NumberFormatException e)
		{
			actualValue = 0;
		}
				
		assertEquals(expectedValue,actualValue,.01);
		
		findElementByCssAndClick("input[value='C']");
		
		delay(100);
				
	}
	
	@Test
	void subtractionTestIntegers() {

		//logger to go here
		System.out.println("SUBTRACT INTEGER TEST");
		
		int expectedValue;
		
		for(int i = 0; i <= 9; i++) {
			
			String numberOne = "input[value='" + i + "']";
			
			for(int j = 0; j <= 9; j++) {
				
				expectedValue = i - j;
				
				findElementByCssAndClick(numberOne);
				findElementByIdAndClick("subtract");
				
				String numberTwo = "input[value='" + j + "']";
				findElementByCssAndClick(numberTwo);
				
				findElementByCssAndClick("input[value='=']");
				
				delay(100);
				
				String actualValueText = driver.findElement(By.id("display")).findElement(By.xpath("//div")).getText();
				 
				int actualValue;
				
				try {
					actualValue = Integer.parseInt(actualValueText);
				}
				catch (NumberFormatException e)
				{
					actualValue = 0;
				}
				
				//loggers would go here
				
				System.out.println("i: " + i + " j: " + j);
				System.out.println("expectedValue: " + expectedValue + " actualValue: " + actualValue);
				
				assertEquals(expectedValue,actualValue);
				
				findElementByCssAndClick("input[value='C']");
				
				delay(100);
				
			}
		}
		
	}
	
	@Test
	void subtractionTestDecimals() {

		//logger to go here
		System.out.println("SUBTRACT DECIMAL TEST");
		
		float expectedValue = 8.43f;
		
		findElementByCssAndClick("input[value='9']");
		findElementByCssAndClick("input[value='.']");
		findElementByCssAndClick("input[value='8']");
		findElementByCssAndClick("input[value='7']");

		findElementByIdAndClick("subtract");
		
		findElementByCssAndClick("input[value='1']");
		findElementByCssAndClick("input[value='.']");
		findElementByCssAndClick("input[value='4']");
		findElementByCssAndClick("input[value='4']");
				
		findElementByCssAndClick("input[value='=']");
		
		delay(100);
		
		String actualValueText = driver.findElement(By.id("display")).findElement(By.xpath("//div")).getText();
		 
		float actualValue;
		
		try {
			actualValue = Float.parseFloat(actualValueText);
		}
		catch (NumberFormatException e)
		{
			actualValue = 0;
		}
				
		assertEquals(expectedValue,actualValue,.01);
		
		findElementByCssAndClick("input[value='C']");
		
		delay(100);
		
	}
	
	@Test
	void multiplyTestIntegers() {

		//logger to go here
		System.out.println("MULTIPLY INTEGER TEST");
		
		int expectedValue;
		
		for(int i = 0; i <= 9; i++) {
			
			String numberOne = "input[value='" + i + "']";
			
			for(int j = 0; j <= 9; j++) {
				
				expectedValue = i * j;
				
				findElementByCssAndClick(numberOne);
				findElementByIdAndClick("multiply");
				
				String numberTwo = "input[value='" + j + "']";
				findElementByCssAndClick(numberTwo);
				
				findElementByCssAndClick("input[value='=']");
				
				delay(100);
				
				String actualValueText = driver.findElement(By.id("display")).findElement(By.xpath("//div")).getText();
				 
				int actualValue;
				
				try {
					actualValue = Integer.parseInt(actualValueText);
				}
				catch (NumberFormatException e)
				{
					actualValue = 0;
				}
				
				//loggers would go here
				
				System.out.println("i: " + i + " j: " + j);
				System.out.println("expectedValue: " + expectedValue + " actualValue: " + actualValue);
				
				assertEquals(expectedValue,actualValue);
				
				findElementByCssAndClick("input[value='C']");
				
				delay(100);
				
			}
		}
		
	}
	
	@Test
	void multiplyTestDecimals() {

		//logger to go here
		System.out.println("MULTIPLY DECIMAL TEST");
		
		float expectedValue = 7.04f;
		
		findElementByCssAndClick("input[value='6']");
		findElementByCssAndClick("input[value='.']");
		findElementByCssAndClick("input[value='4']");

		findElementByIdAndClick("multiply");
		
		findElementByCssAndClick("input[value='1']");
		findElementByCssAndClick("input[value='.']");
		findElementByCssAndClick("input[value='1']");
				
		findElementByCssAndClick("input[value='=']");
		
		delay(100);
		
		String actualValueText = driver.findElement(By.id("display")).findElement(By.xpath("//div")).getText();
		 
		float actualValue;
		
		try {
			actualValue = Float.parseFloat(actualValueText);
		}
		catch (NumberFormatException e)
		{
			actualValue = 0;
		}
				
		assertEquals(expectedValue,actualValue,.01);
		
		findElementByCssAndClick("input[value='C']");
		
		delay(100);
		
	}
	
	@Test
	void divisionTestIntegers() {

		//logger to go here
		System.out.println("DIVIDE INTEGER TEST");
		
		float expectedValue;
		
		for(int i = 0; i <= 9; i++) {
			
			String numberOne = "input[value='" + i + "']";
			
			//start at 1 to avoid divide by zero arithmetic error, just test that manually
			
			for(int j = 1; j <= 9; j++) {
				
				expectedValue = ((float) i) / ((float) j);
				findElementByCssAndClick(numberOne);
				findElementByIdAndClick("divide");
				
				String numberTwo = "input[value='" + j + "']";
				findElementByCssAndClick(numberTwo);
				
				findElementByCssAndClick("input[value='=']");
				
				delay(100);
				
				String actualValueText = driver.findElement(By.id("display")).findElement(By.xpath("//div")).getText();
				 
				float actualValue;
				
				try {
					actualValue = Float.parseFloat(actualValueText);
				}
				catch (NumberFormatException e)
				{
					actualValue = 0;
				}
				
				//loggers would go here
				
				System.out.println("i: " + i + " j: " + j);
				System.out.println("expectedValue: " + expectedValue + " actualValue: " + actualValue);
				
				assertEquals(expectedValue,actualValue,.01);
				
				findElementByCssAndClick("input[value='C']");
				
				delay(100);
				
			}
		}
		
	}
	
	@Test
	void divisionTestDecimals() {

		//logger to go here
		System.out.println("DIVIDE DECIMAL TEST");
		
		float expectedValue = 1.34f;
		
		findElementByCssAndClick("input[value='2']");
		findElementByCssAndClick("input[value='.']");
		findElementByCssAndClick("input[value='6']");
		findElementByCssAndClick("input[value='8']");

		findElementByIdAndClick("divide");
		
		findElementByCssAndClick("input[value='2']");
		findElementByCssAndClick("input[value='.']");
		findElementByCssAndClick("input[value='0']");
		findElementByCssAndClick("input[value='0']");
				
		findElementByCssAndClick("input[value='=']");
		
		delay(100);
		
		String actualValueText = driver.findElement(By.id("display")).findElement(By.xpath("//div")).getText();
		 
		float actualValue;
		
		try {
			actualValue = Float.parseFloat(actualValueText);
		}
		catch (NumberFormatException e)
		{
			actualValue = 0;
		}
				
		assertEquals(expectedValue,actualValue,.01);
		
		findElementByCssAndClick("input[value='C']");
		
		delay(100);
		
	}

	void findElementByCssAndClick(String cssSelector) {
		driver.findElement(By.cssSelector(cssSelector)).click();
	}
	
	String findElementByCssAndGetAttribute(String cssSelector, String attribute) {
		return driver.findElement(By.cssSelector(cssSelector)).getAttribute(attribute);
	}
	
	String findElementByCssAndGetText(String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector)).getText();
	}
	
	void findElementByXpathAndClick(String cssSelector) {
		driver.findElement(By.xpath(cssSelector)).click();
	}
	
	String findElementByXpathAndGetAttribute(String xPath, String attribute) {
		return driver.findElement(By.xpath(xPath)).getAttribute(attribute);
	}
	
	void findElementByIdAndClick(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	void delay(int milliseconds) {
		
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}