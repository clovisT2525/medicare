//package medicare;
//
//import static org.junit.Assert.assertEquals;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//
//public class AddTagTest {
//	public WebDriver driver;
//	public String baseUrl = Constant.BASE_PATH+"addTag.jsp";
//	
//	@BeforeTest
//	public void setup() {
//		System.setProperty("webdriver.gecko.driver", Constant.DRIVER_PATH);
//		FirefoxOptions options = new FirefoxOptions();
//		options.setHeadless(true);
//		options.setBinary("/usr/bin/firefox");
//		driver = new FirefoxDriver(options);
//		driver.get(baseUrl);
//	}
//	
//	@Test
//	public void checkTitle() {
//		String a="Admin - Add Tag";
//		String b=driver.getTitle();
//		assertEquals(a, b);
//	}
//	
//	@Test
//	public void checkElement1() {
//		String a="Enter new Tag details";
//		String b=driver.findElement(By.className("display-6")).getText();
//		assertEquals(a, b);
//	}
//
//	@Test
//	public void checkElement2() {
//		String a = "Name:";
//		String b =driver.findElement(By.className("form-label")).getText();
//		assertEquals(a, b);
//	}
//
//	@Test
//	public void checkElement3() {
//		Boolean b =driver.findElement(By.className("form-control")).isDisplayed();
//		assertEquals(true, b);
//	}
//
//	@Test
//	public void checkElement4() {
//		Boolean b =driver.findElement(By.className("btn")).isDisplayed();
//		assertEquals(true, b);
//	}
//	
//	@AfterTest
//	public void cleanup() {
//		driver.quit();
//	}
//	
//}
