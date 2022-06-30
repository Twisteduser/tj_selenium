import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SeleniumAlpha {

    public static void main(String[] args)  throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/home/gszabo/Documents/selenium_project/chromedriver/chromedriver");
        ChromeDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("https://stage.m2commerce.itg.cloud");
        System.out.println(driver.getTitle());

        WebElement SearchBox = driver.findElement(By.id("search"));
        SearchBox.sendKeys("T-shirt"+ Keys.ENTER);
        Thread.sleep(4000);

        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        driver.quit();

    }
}
