package CurrencyAuto.CurrencyAuto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.google.com");
        System.out.println( "Hello World!" );
    }
}
