package CurrencyAuto.CurrencyAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CurrencyPageModel {
	
	private WebDriver driver;
	
	//*********Web Elements by using Page Factory*********
    @FindBy(how = How.ID, using = "amount")
    public WebElement amount;
 
    @FindBy(how = How.ID, using = "ucc_go_btn_svg")
    public WebElement convert;

    @FindBy(how = How.XPATH, using = "//span[@class='uccResultAmount']")
    public WebElement ConvertedAmount;
  
	public CurrencyPageModel(WebDriver driver) {
		
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}
	
	public WebElement ConversionRate(String to, String base) {
				
		return driver.findElement(By.xpath("//a[contains(@rel,'" + to + "," + base + "')]"));			
	}
	
	public WebElement currencyFromSeletion(String currency) {
		
		return driver.findElement(By.xpath("//*[@id='from_scroller']/li[contains(text(),'" + currency + "')][contains(@class,'ac_recent')]"));			
	}
	
	public WebElement currencyToSeletion(String currency) {
		
		return driver.findElement(By.xpath("//*[@id='to_scroller']/li[contains(text(),'" + currency + "')][contains(@class,'ac_recent')]"));			
	}
}
