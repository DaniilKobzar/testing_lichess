package selenium_proj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Maintest_lichess {

    private WebDriver driver;
    String url="https://lichess.org/";
    String In="//a[contains(@class, 'signin button button-empty')]";
    String Name="//input[contains(@name, 'username')]";
    String PW="//input[contains(@name, 'password')]";
    String But="//button[contains(@class, 'submit button')]";
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
    String out="//a[contains(@id, 'user_tag')]";
    String outt="//button[contains(@data-icon, 'w')]";



    @Test
    public void test() throws InterruptedException {
        System.out.println("Lets get started!");

        WebDriverWait search01 = new WebDriverWait(driver, 15);
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(In))).click();
        Thread.sleep(1000);
        //1 user
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Name))).sendKeys(name1);
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PW))).sendKeys(pw1);
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(But))).click();
        Thread.sleep(2000);
        WebElement source = driver.findElement(By.xpath(out));
        Assert.assertEquals(name1, source.getText());
        System.out.println(source.getText());

        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(out))).click();
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(outt))).click();
        Thread.sleep(2000);
        System.out.println("1 user ok!");
        /*
        //2user
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Name))).sendKeys(name2);
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PW))).sendKeys(pw2);
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(But))).click();
        Thread.sleep(2000);
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(out))).click();
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(outt))).click();
        Thread.sleep(2000);
        System.out.println("2 user ok!");
        //3user
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Name))).sendKeys(name3);
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PW))).sendKeys(pw3);
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(But))).click();
        Thread.sleep(2000);
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(out))).click();
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(outt))).click();
        Thread.sleep(2000);
        System.out.println("3 user ok!");
        //4user
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Name))).sendKeys(name4);
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PW))).sendKeys(pw4);
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(But))).click();
        Thread.sleep(2000);
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(out))).click();
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(outt))).click();
        Thread.sleep(2000);
        System.out.println("4 user ok!");
        //5user
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Name))).sendKeys(name5);
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PW))).sendKeys(pw5);
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(But))).click();
        Thread.sleep(2000);
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(out))).click();
        search01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(outt))).click();
        Thread.sleep(2000);
        System.out.println("5 user ok!");
*/


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
