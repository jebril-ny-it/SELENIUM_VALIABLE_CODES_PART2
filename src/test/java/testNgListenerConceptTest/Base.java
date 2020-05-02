package testNgListenerConceptTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver driver;


  

	public static void initialization() {

		System.setProperty("webdriver.chrome.driver", "/Users/mohammadjebril/eclipse-workspace/AmgenFirstStep/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}

	public void failed(String testmethodname) {
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile,
					new File("/Users/mohammadjebril/eclipse-workspace/ScreenShotConcept/screenshots/"+testmethodname+"_"+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
