import configuration.ReadProperties;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocatorsSauceDemo {
    private WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new BrowserService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void basicLocatorTest() throws InterruptedException {
        driver.get(ReadProperties.getUrl());
        Thread.sleep(1000);
        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.getUserName());
        driver.findElement(By.name("password")).sendKeys(ReadProperties.getPassword());
        driver.findElement(By.className("submit-button")).click();
        Thread.sleep(3000);

    Assert.assertTrue(driver.findElement(By.tagName("ul")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.linkText("Twitter")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.partialLinkText("Backpack")).isDisplayed());

    Assert.assertTrue(driver.findElement(By.cssSelector(".app_logo")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.cssSelector(".btn.btn_primary")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.cssSelector(".inventory_list .inventory_item")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.cssSelector("#page_wrapper")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.cssSelector("footer")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.cssSelector("li.social_linkedin")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.cssSelector("[data-test=product_sort_container]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.cssSelector("[class|=bm]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.cssSelector("[class ^=bm-]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.cssSelector("[alt~=Backpack]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.cssSelector("[alt$=pack]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.cssSelector("[class*=kedin]")).isDisplayed());

    Assert.assertTrue(driver.findElement(By.xpath("//ul")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("//div[@id='page_wrapper']")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'kpack')]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id,'pag')]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("//div/ancestor::a[@id='item_1_title_link']")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("//div//descendant::span")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("//ul/parent::footer")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("//div/div[@class='inventory_item']/preceding::img")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("//div/div[@class='inventory_item']/following-sibling::div")).isDisplayed());
    }

}