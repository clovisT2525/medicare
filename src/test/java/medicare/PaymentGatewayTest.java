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
//public class PaymentGatewayTest {
//	public WebDriver driver;
//	public String baseUrl = Constant.BASE_PATH+"paymentGateway.jsp";
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
//		String a="User - Payment Gateway";
//		String b=driver.getTitle();
//		assertEquals(a, b);
//	}
//	
//	@Test
//	public void checkElement1() {
//		String a="Payment Mechanism";
//		String b=driver.findElement(By.className("display-4")).getText();
//		assertEquals(a, b);
//	}
//
//	@Test
//	public void checkElement2() {
//		Boolean b =driver.findElement(By.name("cartInfo")).isDisplayed();
//		assertEquals(false, b);
//	}
//
//	@Test
//	public void checkElement3() {
//		Boolean b =driver.findElement(By.id("cod")).isDisplayed();
//		assertEquals(true, b);
//	}
//
//	@Test
//	public void checkElement4() {
//		String a = "Cash On Delivery";
//		String b =driver.findElement(By.className("form-check-label")).getText();
//		assertEquals(a, b);
//	}
//	@Test
//	public void checkElement5() {
//		Boolean b =driver.findElement(By.id("wallet")).isDisplayed();
//		assertEquals(true, b);
//	}
//	@Test
//	public void checkElement6() {
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
