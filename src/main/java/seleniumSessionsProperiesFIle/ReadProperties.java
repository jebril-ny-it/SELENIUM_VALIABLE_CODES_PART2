package seleniumSessionsProperiesFIle;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class ReadProperties {

	static WebDriver driver;

	static Properties prop;

	public static void main(String[] args) throws IOException {

		// HOW TO READ PROPERTIES
		//1.create object ref. of properties
		prop = new Properties();
		
		//2.create ref var of FileInputStream
		FileInputStream ip = new FileInputStream(
				"/Users/mohammadjebril/eclipse-workspace/ScreenShotConcept/src/main/java/seleniumSessionsProperiesFIle/config.properties");
		
		//3.load ip the ref variable fileinputStream into prop
		prop.load(ip);

		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/mohammadjebril/eclipse-workspace/AmgenFirstStep/chromedriver");
			driver = new ChromeDriver();

		} else if (browserName.equals("FF")) {
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			driver = new InternetExplorerDriver();

		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		}

		driver.get(prop.getProperty("url"));
		
		driver.findElement(By.xpath("")).sendKeys(prop.getProperty("username"));
		
		driver.findElement(By.xpath("")).sendKeys(prop.getProperty("password"));
		
	}

}
