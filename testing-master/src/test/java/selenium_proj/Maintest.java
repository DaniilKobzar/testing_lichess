package selenium_proj;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.w3c.dom.ls.LSOutput;

public class Maintest {

    private WebDriver driver;
    String url="https://www.rzd.ru/";

    @Test
    public void test() throws InterruptedException {
        System.out.println("ok!");


        //1 клик картинки
    WebDriverWait search01 = new WebDriverWait(driver, 15);
         search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder, 'Откуда')]"))).sendKeys("Москва");
        Thread.sleep(2000);
         search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder, 'Куда')]"))).sendKeys("Санкт-Петербург");
        Thread.sleep(2000);
         //search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@title, 'Дата')]"))).click();
         //search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@title, 'Дата')]"))).clear();
         search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@onclick, 'stepDate(0,1)')]"))).click();
         Thread.sleep(2000);
         search01.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id, 'Submit')]"))).click();

        //WebDriverWait search01 = new WebDriverWait(driver, 15);
       // search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@aria-label, 'Запрос')]"))).sendKeys("котики");
        //search01.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@role, 'button')]"))).click();
        //search01.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'button suggest2')]"))).click();
        Thread.sleep(5000);

        //  WebDriverWait buttonNewPaymentClickable = new WebDriverWait(driver, 15);
        //search01.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Картинки')]"))).clear();;

        //или

        //WebDriverWait search01 = new WebDriverWait(driver, 15);
        //   search01.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Картинки')]"))).click();


    }

    // Выбор: mvn -Dbrowser=Chrome   либо   -Dbrowser=Firefox
    @Parameters("browser")
    @BeforeClass
    protected void driverSetup (@Optional("Chrome") String browser) {
        DriverFactory factory = new DriverFactory();
        driver = factory.setup(browser);
        driver.get(url);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}


