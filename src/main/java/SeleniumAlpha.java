import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class SeleniumAlpha {

    public static void main(String[] args)  throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/home/gszabo/Documents/selenium_project/chromedriver/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
        driver.get("https://stage.m2commerce.itg.cloud");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        WebElement SearchBox = driver.findElement(By.id("search"));
        SearchBox.sendKeys("T-shirt"+ Keys.ENTER);
        Thread.sleep(1000);

        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        driver.quit();

    }
}
