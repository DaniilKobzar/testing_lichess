package selenium_proj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FrameLeftMiddleRightBottom {

    private WebDriver driver;
    String url="http://the-internet.herokuapp.com/";
    String framesMenu="//a[contains(text(), 'Frames')]";
    String nestedFramesMenu="//a[contains(text(), 'Nested Frames')]";
    String frameBottom="//body[contains(text(),'BOTTOM')]";
    String frameMiddle="//div[@id='content']";
    String frameTopElementXp="//frame[@name='frame-top']";
    String frameMiddleElementXp="//frame[@name='frame-middle']";
    String frameLeftElementXp="//frame[@name='frame-left']";
    String frameRightElementXp="//frame[@name='frame-right']";
    String leftText="//body[contains(text(), 'LEFT')]";
    String rightText="//body[contains(text(),'RIGHT')]";


    @Test
    public void test() throws InterruptedException {
        System.out.println("Lets get started!");


        WebDriverWait framesMenuLink = new WebDriverWait(driver, 15);
        framesMenuLink.until(ExpectedConditions.elementToBeClickable(By.xpath(framesMenu))).click();

        WebDriverWait nestedFramesMenuLink = new WebDriverWait(driver, 15);
        nestedFramesMenuLink.until(ExpectedConditions.elementToBeClickable(By.xpath(nestedFramesMenu))).click();

        driver.switchTo().frame("frame-bottom");

        WebDriverWait frameBottomText = new WebDriverWait(driver, 15);
        String bottom = frameBottomText.until(ExpectedConditions.elementToBeClickable(By.xpath(frameBottom))).getText();
        System.out.println(bottom);

        Thread.sleep(3000);

        driver.switchTo().defaultContent();
        WebElement frameTop = driver.findElement(By.xpath(frameTopElementXp));
        driver.switchTo().frame(frameTop);

        WebElement frameMiddleXp = driver.findElement(By.xpath(frameMiddleElementXp));
        driver.switchTo().frame(frameMiddleXp);

        Thread.sleep(3000);

        WebDriverWait frameMiddleText = new WebDriverWait(driver, 15);
        String middle = frameMiddleText.until(ExpectedConditions.elementToBeClickable(By.xpath(frameMiddle))).getText();
        System.out.println(middle);

        driver.switchTo().defaultContent();
        WebElement frameTop2 = driver.findElement(By.xpath(frameTopElementXp));
        driver.switchTo().frame(frameTop2);

        WebElement frameLeftXp = driver.findElement(By.xpath(frameLeftElementXp));
        driver.switchTo().frame(frameLeftXp);

        WebDriverWait frameLeftText = new WebDriverWait(driver, 15);
        String left = frameLeftText.until(ExpectedConditions.elementToBeClickable(By.xpath(leftText))).getText();
        System.out.println(left);

        //////

        driver.switchTo().defaultContent();
        WebElement frameTop3 = driver.findElement(By.xpath(frameTopElementXp));
        driver.switchTo().frame(frameTop3);

        WebElement frameRightXp = driver.findElement(By.xpath(frameRightElementXp));
        driver.switchTo().frame(frameRightXp);

        WebDriverWait frameRightText = new WebDriverWait(driver, 15);
        String right = frameRightText.until(ExpectedConditions.elementToBeClickable(By.xpath(rightText))).getText();
        System.out.println(right);

        Thread.sleep(3000);


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
