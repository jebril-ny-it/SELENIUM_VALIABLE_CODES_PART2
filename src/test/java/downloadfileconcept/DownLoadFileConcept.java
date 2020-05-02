package downloadfileconcept;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ISelect;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DownLoadFileConcept {

	WebDriver driver;
	File folder;

	@BeforeMethod
	public void setup() {

		// 8886-43254-2345=99988=98069
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();

		// chrome
		System.setProperty("webdriver.chrome.driver",
				"/Users/mohammadjebril/eclipse-workspace/AmgenFirstStep/chromedriver");

		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", folder.getAbsoluteFile());

		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);

		driver = new ChromeDriver(cap);

	}

	@Test
	public void downloadFileTest() throws InterruptedException {
		driver.get("https://www.the-internet.herokuapp.com/downloads");
		driver.findElement(By.xpath(""));

		Thread.sleep(2000);
		
		File listOfFiles[] = folder.listFiles();
		Assert.assertTrue(listOfFiles.length > 0);
		
		for (File file : listOfFiles) {
			// make sure that downloads file is not empty
			Assert.assertTrue(file.length() > 0);
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

		for (File file : folder.listFiles()) {
			file.delete();
		}
		folder.delete();
	}

}
