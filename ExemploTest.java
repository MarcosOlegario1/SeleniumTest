package net.weg.easy.webdriver.catalog;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestCase;

public class ExemploTest extends TestCase {

	private WebDriver driver;
	private static String email = "catolicarma@gmail.com";
	private static String senha = "catolica@2019";
	private static int waitLoadPageTime = 20;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vinis\\Desktop\\cat-test-system\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testSelenium() throws Exception {
		driver.get("http://www.gmail.com.br/");
		sendToElement(By.name("identifier"), email + Keys.ENTER);
		waitElement(By.name("password"), waitLoadPageTime);
		sendToElement(By.name("password"), senha + Keys.ENTER);
		waitElement(By.cssSelector("div[data-tooltip='Caixa de entrada']"), waitLoadPageTime);
		driver.findElement(By.cssSelector("div.aic div.z0 div[role='button']")).click();

		waitElement(By.cssSelector("textarea[name='to']"), waitLoadPageTime);

		sendToElement(By.cssSelector("textarea[name='to']"), email + Keys.ENTER);
		sendToElement(By.name("subjectbox"), "Teste de Selenium");
		sendToElement(By.cssSelector("div[aria-label='Corpo da mensagem'][role='textbox']"),
				"Teste de automatizacao");
		driver.findElement(By.cssSelector("div[role='button'][aria-label='Enviar ‪(Ctrl-Enter)‬']")).click();
	
	waitElement(By.cssSelector("div[role='tabpanel'] tbody>tr>td:nth-of-type(5) span[name='eu']"),
			waitLoadPageTime);
	assertTrue(driver.findElement(
			By.cssSelector("div[role='tabpanel'] tbody>tr>td:nth-of-type(5) span[name='eu']")) != null);
	driver.findElement(By.cssSelector("div[role='tabpanel'] tbody>tr>td:nth-of-type(6)")).click();

	waitElement(By.cssSelector("div[role='button'][aria-label='Responder'][data-tooltip='Responder']"),
			waitLoadPageTime);

	driver.findElement(By.cssSelector("div[role='button'][aria-label='Responder'][data-tooltip='Responder']"))
			.click();

	waitElement(By.cssSelector("div[role='textbox'][aria-label='Corpo da mensagem']"), waitLoadPageTime);

	sendToElement(By.cssSelector("div[role='textbox'][aria-label='Corpo da mensagem']"),
			"Leu isso aqui, falou");
	driver.findElement(By.cssSelector("div[role='button'][aria-label='Enviar ‪(Ctrl-Enter)‬']")).click();
	
	waitElement(By.cssSelector("div[data-tooltip=\"Caixa de entrada\"]"), waitLoadPageTime);
	driver.findElement(By.cssSelector("div[class=\"qj qr\"]")).click();
	//da um load e marca
	waitElement(By.cssSelector("div[data-tooltip='Caixa de entrada']"),waitLoadPageTime);
	driver.findElement(By.cssSelector("td[class=\"oZ-x3 xY\"]")).click();

	driver.findElement(By.cssSelector("div[class=\"asa\"]")).click();
	waitElement(By.cssSelector("div[role='main'] tbody>tr>td:nth-of-type(5) span:nth-of-type(2)"),
			waitLoadPageTime);
	pause();
	driver.findElement(By.cssSelector("header>div:nth-child(2)>div:nth-child(3)>div>div:nth-child(2) a")).click();
	pause();
	//desloga
	driver.findElement(
			By.cssSelector("header>div:nth-child(2)>div:nth-child(5)>div:nth-child(4)>div:nth-child(2)> a"))
			.click();
	waitElement(By.name("identifier"), waitLoadPageTime);
}

	private void pause() throws InterruptedException {
		Thread.sleep(1000);
	}

	private void waitElement(By by, int outTime) throws InterruptedException {
		new WebDriverWait(driver, outTime).until(ExpectedConditions.presenceOfElementLocated(by));
		pause();
	}

	private void sendToElement(By by, String string) {
		driver.findElement(by).sendKeys(string);
	}
}