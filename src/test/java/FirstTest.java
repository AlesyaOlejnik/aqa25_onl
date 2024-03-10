import configuration.ReadProperties;
import core.AdvancedDriver;
import core.BrowserService;
import core.SimpleDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FirstTest {
    @Test
    public void simpleDriverTest() {
        SimpleDriver simpleDriver = new SimpleDriver();
        WebDriver driver = simpleDriver.getDriver();
        driver.get("http://google.com");
        driver.quit();
    }

    @Test
    public void advancedDriverTest(){
        AdvancedDriver advancedDriver = new AdvancedDriver();
        WebDriver driver = advancedDriver.getDriver();
        driver.get(ReadProperties.getUrl());
        driver.quit();
    }

    @Test
    public void browserServiceTest() {
        BrowserService browserService = new BrowserService();
        WebDriver driver = browserService.getDriver();
        driver.get(ReadProperties.getUrl());
        driver.quit();
    }
}
