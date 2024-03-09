package data;

import org.testng.annotations.DataProvider;

public class DataIntProvider {
    @DataProvider(name = "dataForIntDivision")
    public static Object[][] dataForIntDivisionTest() {
        return new Object[][]{
                {10, 5, 2},
                {-8, -4, 2},
                {25, 5, 5}
        };
    }
}
