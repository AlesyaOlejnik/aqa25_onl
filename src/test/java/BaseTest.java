import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        BrowserService browserService = new BrowserService();
        driver = browserService.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    protected void setValueToElement(String elementId, String value) {
        WebElement element = driver.findElement(By.id(elementId));
        element.sendKeys(value);
    }

    protected void setValueToSelectElement(String elementId, int index) {
        WebElement element = driver.findElement(By.id(elementId));
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    protected void setValueToSelectElement(String elementId, String value) {
        WebElement element = driver.findElement(By.id(elementId));
        Select select = new Select(element);
        select.selectByValue(value);
    }

    protected void checkResult(String elementId, String expectedText) {
        WebElement element = driver.findElement(By.id(elementId));
        String text = element.getText();
        Assert.assertEquals(text, expectedText);
    }

}
