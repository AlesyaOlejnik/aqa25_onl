package testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import testng.Retry;

public class RetryTest {
    private int attempt = 1;

    @Test(retryAnalyzer = Retry.class)
    public void flukyTest() {
        if (attempt == 3) {
            Assert.assertTrue(true);
        } else {
            attempt++;
            System.out.println("Attempt is : " + attempt);
            throw new NullPointerException();
        }

    }
}
