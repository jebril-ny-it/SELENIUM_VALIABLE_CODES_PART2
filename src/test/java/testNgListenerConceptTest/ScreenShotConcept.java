package testNgListenerConceptTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class ScreenShotConcept extends Base {

	@BeforeMethod
	public void setUp() {
		initialization();
	}

	@Test
	public void takeScreenshotTest1() {
		Assert.assertEquals(true, false);
	}

	@Test
	public void takeScreenshotTest2() {
		Assert.assertEquals(true, false);
	}

	@Test
	public void takeScreenshotTest3() {
		Assert.assertEquals(true, false);
	}

	

	@AfterMethod
	public void tesrDown() {
		driver.quit();
	}

}
