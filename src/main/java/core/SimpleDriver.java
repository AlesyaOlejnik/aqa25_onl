package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDriver {
    //класс,который создает хром драйвер,отдает и можно начинать работу
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\aqa25_onl\\src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        return new  ChromeDriver();
    }
}
