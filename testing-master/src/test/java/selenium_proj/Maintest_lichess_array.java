package selenium_proj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class Maintest_lichess_array {

    private WebDriver driver;
    String url="https://lichess.org/";
    String In="//a[contains(@class, 'signin button button-empty')]";
    String Name="//input[contains(@name, 'username')]";
    String PW="//input[contains(@name, 'password')]";
    String But="//button[contains(@class, 'submit button')]";
    String[] data = {"DaniilKo", "463160", "testerMarch3", "88888888", "d4__c5", "88888888",
            "Hercules1111111111", "PerformanceLab", "gvalaev", "88888888"};
    /*
    String name1="DaniilKo";
    String pw1="463160";
    String name2="testerMarch3";
    String pw2="88888888";
    String name3="d4__c5";
    String pw3="88888888";
    String name4="Hercules1111111111";
    String pw4="PerformanceLab";
    String name5="gvalaev";
    String pw5="88888888";

     */
    String out="//a[contains(@id, 'user_tag')]";
    String outt="//button[contains(@data-icon, 'w')]";




    @Test
    public void test() throws InterruptedException {
        System.out.println("Lets get started!");
        int count=1;

        WebDriverWait search01 = new WebDriverWait(driver, 15);
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(In))).click();
        Thread.sleep(1000);

        for (int i = 0; i < data.length; i+=2) {
            search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Name))).sendKeys(data[i]);
            search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PW))).sendKeys(data[i+1]);
            search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(But))).click();
            Thread.sleep(2000);
            WebElement source = driver.findElement(By.xpath(out));
            Assert.assertEquals(data[i], source.getText());
            System.out.println(source.getText());
            search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(out))).click();
            search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(outt))).click();
            Thread.sleep(2000);
            System.out.println(count+" user ok!");
            count++;
        }

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
