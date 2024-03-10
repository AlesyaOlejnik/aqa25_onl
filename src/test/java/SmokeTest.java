import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTest {
    private WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();

    }

    @Test
    public void validateIKTCalculation() throws InterruptedException {
        driver.get("https://clinic-cvetkov.ru/company/kalkulyator-imt/");
        WebElement weight = driver.findElement(By.name("weight"));
        weight.sendKeys("58");

        WebElement height = driver.findElement(By.name("height"));
        height.sendKeys("183");

        WebElement button = driver.findElement(By.id("calc-mass-c"));
        button.click();

        Thread.sleep(2000);

        WebElement result = driver.findElement(By.id("imt-result"));
        Assert.assertEquals(result.getText(),"17.3 - Недостаточная (дефицит) масса тела");
    }

    @Test
    public void validateSKF(){
        driver.get("");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
