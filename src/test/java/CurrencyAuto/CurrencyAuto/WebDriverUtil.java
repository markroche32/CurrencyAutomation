package CurrencyAuto.CurrencyAuto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {
	
	public static void SetText(WebElement element, WebDriver driver, String text) {
		
		element.sendKeys(text);
	}

	public static void GetText(WebElement element, WebDriver driver, String text) {
		
		element.getText();
	}
	
	public static void Click(WebElement element, WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);	
		wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();
	}
	
	public static void PickDropdownByText(WebElement element, WebDriver driver, String text) {
		
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
	}
}
