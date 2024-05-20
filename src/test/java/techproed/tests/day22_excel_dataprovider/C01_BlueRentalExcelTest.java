package techproed.tests.day22_excel_dataprovider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C01_BlueRentalExcelTest {
    @Test
    public void test01() {

        //BlueRentalCar Sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();

        //Excel dosyamızdaki tüm email ve passwordler ile login olalım ve login olduğumuzu doğrulayalım
       String path ="src/test/java/techproed/resources/adminTestData.xlsx";
       String pageName ="customer_info";
        ExcelReader excelReader = new ExcelReader(path,pageName);
        for (int i = 1; i <excelReader.rowCount()+1 ; i++) {
            blueRentalPage.loginButton.click();
            blueRentalPage.email.sendKeys(excelReader.getCellData(i, 0));
            blueRentalPage.password.sendKeys(excelReader.getCellData(i, 1),Keys.ENTER);
            blueRentalPage.loginVerify.click();
            Assert.assertTrue(blueRentalPage.logout.isDisplayed());
            blueRentalPage.logout.click();
            blueRentalPage.okButton.click();
        }
        Driver.closeDriver();
    }

}