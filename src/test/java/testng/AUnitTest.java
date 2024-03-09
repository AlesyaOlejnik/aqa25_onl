package testng;

import org.testng.annotations.Test;

public class AUnitTest extends BaseTest{
    @Test
    public void archTest1(){
        System.out.println("Test executed..." + counter);
        System.out.println("Test executed..." + calculator.hashCode());
        System.out.println("Random..." + var);
    }
    @Test
    public void archTest2(){
        System.out.println("Test executed..." + counter);
        System.out.println("Random..." + var);
    }
}
