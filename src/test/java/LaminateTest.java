import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaminateTest extends BaseTest {

    @Test
    public void validateLaminateCalculation() throws InterruptedException {
        driver.get("https://home-ex.ru/calculation/");
        clearAndSetValueToElement("ln_room_id", "400");
        clearAndSetValueToElement("wd_room_id", "300");
        clearAndSetValueToElement("ln_lam_id", "1000");
        clearAndSetValueToElement("wd_lam_id", "270");
        clearAndSetValueToElement("n_packing", "9");
        clearAndSetValueToElement("area", "7");
        clickOnButtonById("direction-laminate-id1");
        setValueToElement("laying_method_laminate", "со смещением на 1/2 длины");
        Thread.sleep(10000);
        clickOnButtonById("btn_calculate");
        checkResultByXpath("//*[@id=\"calc\"]/div[1]/div[2]/div[1]", "Требуемое количество плашек ламината: 46");
        checkResultByXpath("//*[@id=\"calc\"]/div[1]/div[2]/div[2]", "Количество упаковок ламината: 6");
    }

    private void clickOnButtonById(String id) {
        WebElement radioButton = driver.findElement(By.id(id));
        radioButton.click();
    }

    private void clearAndSetValueToElement(String elementId, String value) {
        WebElement element = driver.findElement(By.id(elementId));
        element.clear();
        element.sendKeys(value);
    }

    private void checkResultByXpath(String xpath, String expectedText) {
        WebElement element = driver.findElement(By.xpath(xpath));
        String text = element.getText();
        Assert.assertEquals(text, expectedText);
    }
}
