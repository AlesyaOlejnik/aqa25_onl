import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ByMedTest extends BaseTest {

    @Test
    public void validateGFRCalculation() throws InterruptedException {
        driver.get("https://bymed.top/calc/%D1%81%D0%BA%D1%84-2148");
        Thread.sleep(2000);

        driver.switchTo().frame(0); // у меня работает только с этим индексом фрейма

        setValueToElement("age", "24");
        setValueToSelectElement("sex", 1);
        setValueToElement("cr", "50");
        setValueToSelectElement("cr-size", "mg");
        setValueToSelectElement("race", "N");
        setValueToElement("mass", "70");
        setValueToElement("grow", "170");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        Thread.sleep(2000);

        checkResult("mdrd", "0.9 мл/мин/1.73м2 - Терминальная почечная недостаточность (C5)");
        checkResult("ckd_epi", "0.81 мл/мин/1.73м2 - Терминальная почечная недостаточность (C5)");
        checkResult("cge", "1.92 мл/мин");
        checkResult("schwartz", "");
    }
}
