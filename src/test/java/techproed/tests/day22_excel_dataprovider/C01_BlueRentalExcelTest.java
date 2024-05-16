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
        for (int i = 1; i <= excelReader.rowCount(); i++) {
            String email = excelReader.getCellData(i,0);
            String password = excelReader.getCellData(i,1);

            blueRentalPage.loginButton.click();
            blueRentalPage.email.sendKeys(email);
            blueRentalPage.password.sendKeys(password, Keys.ENTER);

            blueRentalPage.loginVerify.click();
            Assert.assertTrue(blueRentalPage.profile.isDisplayed());

            ReusableMethods.waitForSecond(2);
            blueRentalPage.logout.click();
            blueRentalPage.okButton.click();
            ReusableMethods.waitForSecond(2);
        }

        Driver.closeDriver();
    }
}