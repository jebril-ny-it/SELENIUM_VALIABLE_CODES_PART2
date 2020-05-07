package webTablesHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import util.Xls_Reader;

public class WebTableHandling {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"/Users/mohammadjebril/eclipse-workspace/AmgenFirstStep/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");
		// Comapany Coloum
		// *[@id='customers']/tbody/tr[2]/td[1]
		// *[@id="customers"]/tbody/tr[3]/td[1]
		// *[@id="customers"]/tbody/tr[4]/td[1]
		// *[@id="customers"]/tbody/tr[7]/td[1]

		// contact coloum
		// *[@id="customers"]/tbody/tr[2]/td[2]
		// *[@id="customers"]/tbody/tr[3]/td[2]
		// *[@id="customers"]/tbody/tr[4]/td[2]
		String beforeXpath_company = "//*[@id='customers']/tbody/tr[";
		String afterXpath_company = "]/td[1]";

		String beforeXpath_contacts = "// *[@id=\"customers\"]/tbody/tr[";
		String afterXpath_contacts = "]/td[2]";

		List<WebElement> row = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println("total numbers of rowna = " + (row.size() - 1));
		int rowcount = row.size();

		Xls_Reader reader = new Xls_Reader(
				"/Users/mohammadjebril/eclipse-workspace/ScreenShotAndMoreConcept/src/test/java/TestData/AmgenBackUp.xlsx");

		if (!reader.isSheetExist("TabelData")) {
			reader.addSheet("TabelData");
			reader.addColumn("TabelData", "companyName");
			reader.addColumn("TabelData", "contactName");

		}

		for (int i = 2; i <= rowcount; i++) {
			String actualXpath_company = beforeXpath_company + i + afterXpath_company;
			String companyName = driver.findElement(By.xpath(actualXpath_company)).getText();
			System.out.println(companyName);

			reader.setCellData("TabelData", "companyName", i, companyName);

			String actualXpath_contacts = beforeXpath_contacts + i + afterXpath_contacts;
			String contactName = driver.findElement(By.xpath(actualXpath_contacts)).getText();
			System.out.println(contactName);

			reader.setCellData("TabelData", "contactName", i, contactName);

		}

	}
}
