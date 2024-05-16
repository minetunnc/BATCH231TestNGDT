package techproed.tests.day21_pom_excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C04_ExcelReaderUsage {

    @Test
    public void test01() {

        String path="src/test/java/techproed/resources/adminTestData.xlsx";
        String pageName="customer_info";
        ExcelReader excelReader = new ExcelReader(path,pageName);
        String email = excelReader.getCellData(0,0);
        String password = excelReader.getCellData(0,1);

        System.out.println("email = " + email);
        System.out.println("password = " + password);


    }
}