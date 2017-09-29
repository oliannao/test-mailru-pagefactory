
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class SmokeTest {
	private WebDriver driver;
	private MainPage mainPage;
	private MessagesPage messagesPage;
	private ComposePage composePage;

	@BeforeClass
	public void initBrowes() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void openMainTest() {
		mainPage = new MainPage(driver);
		mainPage.open();
		Assert.assertEquals("Mail.Ru: почта, поиск в интернете, новости, игры", driver.getTitle());
	}

	@Test(priority = 2)
	public void findLoginMainTest() {
		mainPage.findMailboxLoginAndPassword();
	}

	@Test(priority = 3)
	public void loginMainTest() {
		messagesPage = mainPage.enterLoginAndPassword();
		driver.findElement(By.id("PH_logoutLink"));
	}

	@Test(priority = 4)
	public void messagesPageTest() {
		composePage = messagesPage.findMessage();
	}

	@Test(priority = 5)
	public void messagesTest() {
		composePage.findAdressFraimeSend();
	}
}
