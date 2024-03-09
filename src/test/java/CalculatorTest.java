import data.DataDoubleProvider;
import data.DataIntProvider;
import data.Retry;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test(groups = "int group")
    void testIntDivInt() {
        assertEquals(calculator.div(2, 1), 2);
    }

    @Test(enabled = false)
    void testIntDivIntEnabled() {
        assertEquals(calculator.div(2, 1), 2);
    }

    @Test(dataProvider = "dataForIntDivision", dataProviderClass = DataIntProvider.class, groups = "int group")
    public void testIntDateProvider(int a, int b, int expected) {
        Assert.assertEquals(calculator.div(a, b), expected);
    }

    @Test(dataProvider = "dataForDoubleDivision", dataProviderClass = DataDoubleProvider.class, invocationCount = 2, threadPoolSize = 2, invocationTimeOut = 500, groups = "double group")
    public void testDoubleDateProvider(double a, double b, double expected) {
        Assert.assertEquals(calculator.div(a, b), expected);
    }

    @Test(expectedExceptions = ArithmeticException.class, description = "Деление int на 0", dependsOnMethods = "testIntDateProvider", groups = "int group")
    public void testIntDivisionByZero() {
        calculator.div(2, 0);
    }

    @Test(groups = "double group")
    public void testDoublePositiveDivisionByZero() {
        Assert.assertEquals(calculator.div(2.0, 0.0), Double.POSITIVE_INFINITY);
    }

    @Test(testName = "Отрицательный double делим на 0", alwaysRun = true, timeOut = 1000)
    public void testDoubleNegativeDivisionByZero() {
        Assert.assertEquals(calculator.div(-2.0, 0.0), Double.NEGATIVE_INFINITY);
    }

    @Test(retryAnalyzer = Retry.class)
    public void retryTest() {
        Random random = new Random();
        int randomValue = random.nextInt(3);
        Assert.assertThrows(ArithmeticException.class, () -> calculator.div(100, randomValue));
    }
}
