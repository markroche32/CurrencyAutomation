package CurrencyAuto.CurrencyAuto;


import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CurrencyTests {
	
 	private FirefoxDriver driver;
	private double expectedResult;
	private double actualResult;
	 

 @Before
 public void openBrowser(){
	 
     driver = new FirefoxDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     actualResult = expectedResult = 0;
 } 

 @Test
 public void EuroToDollar(){

	 String baseCurrency = "10";
	 driver.get("https://www.xe.com/currencyconverter/");
	 	 
	 //Perform manual conversion - expectedResult
	 double rate = Double.parseDouble(new CurrencyPageModel(driver).ConversionRate("USD", "EUR").getText());
	 expectedResult = CurrencyConvertor.ConvertFromBaseTo(Double.parseDouble(baseCurrency), rate);
	 
	 WebDriverUtil.SetText(new CurrencyPageModel(driver).amount, driver, baseCurrency);
	
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("document.getElementById('from').value='EUR - Euro'");
	 js.executeScript("document.getElementById('to').value='USD - US Dollar'");
	 
	 WebDriverUtil.Click(new CurrencyPageModel(driver).convert, driver);
	 
	 actualResult = Double.parseDouble(new CurrencyPageModel(driver).ConvertedAmount.getText().replace(",", ""));
	  
     Assert.assertEquals(expectedResult, actualResult, 0.001);

 }

 @Test
 public void DollarToEuro(){

	 String baseCurrency = "80";
	 driver.get("https://www.xe.com/currencyconverter/");
	 	 
	 //Perform manual conversion - expectedResult
	 double rate = Double.parseDouble(new CurrencyPageModel(driver).ConversionRate("EUR", "USD").getText());
	 expectedResult = CurrencyConvertor.ConvertFromBaseTo(Double.parseDouble(baseCurrency), rate);
	 
	 WebDriverUtil.SetText(new CurrencyPageModel(driver).amount, driver, baseCurrency);
	
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("document.getElementById('from').value='USD - US Dollar'");
	 js.executeScript("document.getElementById('to').value='EUR - Euro'");
	 
	 WebDriverUtil.Click(new CurrencyPageModel(driver).convert, driver);
	 
	 actualResult = Double.parseDouble(new CurrencyPageModel(driver).ConvertedAmount.getText().replace(",", ""));
	  
     Assert.assertEquals(expectedResult, actualResult, 0.001);

 }

 @Test
 public void GBPToDollar(){

	 String baseCurrency = "700";
	 driver.get("https://www.xe.com/currencyconverter/");
	 	 
	 //Perform manual conversion - expectedResult
	 double rate = Double.parseDouble(new CurrencyPageModel(driver).ConversionRate("USD", "GBP").getText());
	 expectedResult = CurrencyConvertor.ConvertFromBaseTo(Double.parseDouble(baseCurrency), rate);
	 
	 WebDriverUtil.SetText(new CurrencyPageModel(driver).amount, driver, baseCurrency);
	
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("document.getElementById('from').value='GBP - British Pound'");
	 js.executeScript("document.getElementById('to').value='USD - US Dollar'");
	 
	 WebDriverUtil.Click(new CurrencyPageModel(driver).convert, driver);
	 
	 actualResult = Double.parseDouble(new CurrencyPageModel(driver).ConvertedAmount.getText().replace(",", ""));
	  
     Assert.assertEquals(expectedResult, actualResult, 0.009);

 }
 
 
 @Test
 public void GBPToEuro(){

	 String baseCurrency = "2900";
	 driver.get("https://www.xe.com/currencyconverter/");
	 	 
	 //Perform manual conversion - expectedResult
	 double rate = Double.parseDouble(new CurrencyPageModel(driver).ConversionRate("EUR", "GBP").getText());
	 expectedResult = CurrencyConvertor.ConvertFromBaseTo(Double.parseDouble(baseCurrency), rate);
	 
	 WebDriverUtil.SetText(new CurrencyPageModel(driver).amount, driver, baseCurrency);
	
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("document.getElementById('from').value='GBP - British Pound'");
	 js.executeScript("document.getElementById('to').value='EUR - Euro'");
	 
	 WebDriverUtil.Click(new CurrencyPageModel(driver).convert, driver);
	 
	 actualResult = Double.parseDouble(new CurrencyPageModel(driver).ConvertedAmount.getText().replace(",", ""));
	  
     Assert.assertEquals(expectedResult, actualResult, 0.5);

 }
 
 @After
 public void closeBrowser(){
	 
	 driver.close();
 }
}