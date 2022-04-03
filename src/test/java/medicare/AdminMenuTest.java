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
//public class AdminMenuTest {
//	public WebDriver driver;
//	public String baseUrl = Constant.BASE_PATH+"adminMenu.jsp";
//	
//	@BeforeTest
//	public void setup() {
//		System.setProperty("webdriver.gecko.driver", Constant.DRIVER_PATH);
//		FirefoxOptions options = new FirefoxOptions();
//		options.setHeadless(true);
//		driver = new FirefoxDriver(options);
//		driver.get(baseUrl);
//	}
//	
//	@Test
//	public void checkTitle() {
//		String a="Admin - Menu";
//		String b=driver.getTitle();
//		assertEquals(a, b);
//	}
//	
//	@Test
//	public void checkElement1() {
//		String a="Select an option from below";
//		String b=driver.findElement(By.className("display-4")).getText();
//		assertEquals(a, b);
//	}
//
//	@Test
//	public void checkElement2() {
//		Boolean b =driver.findElement(By.id("add_medicine")).isDisplayed();
//		assertEquals(true, b);
//	}
//
//	@Test
//	public void checkElement3() {
//		Boolean b =driver.findElement(By.id("add_tag")).isDisplayed();
//		assertEquals(true, b);
//	}
//
//	@Test
//	public void checkElement4() {
//		Boolean b =driver.findElement(By.id("add_offer")).isDisplayed();
//		assertEquals(true, b);
//	}
//
//	@Test
//	public void checkElement5() {
//		Boolean b =driver.findElement(By.id("add_seller")).isDisplayed();
//		assertEquals(true, b);
//	}
//
//	@Test
//	public void checkElement6() {
//		Boolean b =driver.findElement(By.id("edit_medicine")).isDisplayed();
//		assertEquals(true, b);
//	}
//
//	@Test
//	public void checkElement7() {
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
