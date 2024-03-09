package data;

import org.testng.annotations.DataProvider;

public class DataDoubleProvider {
    @DataProvider(name = "dataForDoubleDivision")
    public static Object[][] dataForDoubleDivisionTest() {
        return new Object[][]{
                {6.0, 3.0, 2.0},
                {4.5, 1.5, 3.0},
                {10.0, 5.0, 2.0}

        };
    }
}
