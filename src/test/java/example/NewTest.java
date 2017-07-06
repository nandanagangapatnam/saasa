package example;
import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class NewTest {
private WebDriver driver;
@Test
public void testEasy() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, 5);
driver.get("http://www.google.com");
wait.until(ExpectedConditions.titleContains("Google"));
String title = driver.getTitle();
//System.out.println(driver.getPageSource());
Assert.assertTrue(StringUtils.contains(title, "Google"));
}
@BeforeTest 
public void beforeTest() {
	File file = new File("C:/Automation QA/IEDriverServer.exe");
	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true); 
	capabilities.setCapability("ignoreZoomSetting", true);
	driver = new InternetExplorerDriver(capabilities);
	
	//driver.manage().window().maximize();	
}
@AfterTest 
public void afterTest() { 
	driver.quit();
}
}