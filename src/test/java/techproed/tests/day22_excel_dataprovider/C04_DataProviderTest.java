package techproed.tests.day22_excel_dataprovider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C04_DataProviderTest {

    @DataProvider
    public static Object[][] credentials() {
        return new Object[][]{
                {ConfigReader.getProperty("blueRentalEmail1"), ConfigReader.getProperty("blueRentalPassword1")},
                {ConfigReader.getProperty("blueRentalEmail2"), ConfigReader.getProperty("blueRentalPassword2")},
                {ConfigReader.getProperty("blueRentalEmail3"), ConfigReader.getProperty("blueRentalPassword3")}
        };
    }

    @Test(dataProvider = "credentials")
    public void test01(String email,String password) {

        // BlueRentalCar Sayfasına Gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        // Login butonuna tıklayalım
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.loginButton.click();

        // Dataprovider Kullanarak verilen email ve password bilgileri ile login olalım
        blueRentalPage.email.sendKeys(email);
        blueRentalPage.password.sendKeys(password, Keys.ENTER);

        // Sayfayı kapatalım
        ReusableMethods.waitForSecond(2);
        Driver.closeDriver();
    }
}