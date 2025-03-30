package utils;
import org.testng.annotations.DataProvider;
import java.io.IOException;

public class DataProviderUtility {

    @DataProvider(name = "loginData1")
    public Object[][] getData() {
        return new Object[][] {
                {"user1", "password1"},
                {"user2", "password2"},
                {"user3", "password3"}
        };
    }

    @DataProvider(name = "loginewData")
    public Object[][] getDataNew() {
        return new Object[][] {
                {"use", "password1"},
                {"us", "password2"},
                {"use", "password3"}
        };
    }




    @DataProvider(name = "loginData")
    public static Object[][] loginDataProvider() throws IOException {
        String filePath = "/src/main/resources/Dummy2.xlsx";  // Path to Excel file
        String sheetName = "Sheet1"; // Sheet Name
        return ExcelUtility.getExcelData(filePath, sheetName);
    }
}