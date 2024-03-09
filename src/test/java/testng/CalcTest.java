package testng;

import testng.data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CalcTest extends BaseClassTest {
    private int count = 0;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("testng.CalcTest Started");
    }

    @Test
    public void testSum() {
        // Assert.assertEquals(calculator.sum(2,3),6,"Неверная сумма двух чисел" );
        Assert.assertEquals(calculator.sum(2, 3), 5);
        counter++;
    }

    @Test(enabled = false)
    public void testEnabled() {
        // Assert.assertEquals(calculator.sum(2,3),6,"Неверная сумма двух чисел" );
        Assert.assertEquals(calculator.sum(2, 3), 5);

    }

    @Test(description = "Тест с описанием")
    public void testDescription() {
        // Assert.assertEquals(calculator.sum(2,3),6,"Неверная сумма двух чисел" );
        Assert.assertEquals(calculator.sum(2, 3), 5);
    }

    @Test(testName = "Переименованный тест")
    public void testName() {
        // Assert.assertEquals(calculator.sum(2,3),6,"Неверная сумма двух чисел" );
        Assert.assertEquals(calculator.sum(2, 3), 5);
    }

    @Test(timeOut = 500)
    public void tesTimeOut() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test(invocationCount = 3, threadPoolSize = 3, invocationTimeOut = 1000)
    public void testInvocationCount() throws InterruptedException {
        Thread.sleep(200);
        System.out.println(count++);
    }

    @Test(dataProvider = "dataForSum", dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void testDataProvider(int a, int b, int expectedResult) throws InterruptedException {
        //Thread.sleep(new Random().nextInt(1000));
        Thread.sleep(500);
        Assert.assertEquals(calculator.sum(a, b), expectedResult, "Неверная сумма двух чисел");

    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testException() {
        List list = null;
        int size = list.size();
    }
}