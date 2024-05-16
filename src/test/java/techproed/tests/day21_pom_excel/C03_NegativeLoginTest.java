package techproed.tests.day21_pom_excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C03_NegativeLoginTest {


    //Name:
    //US100208_Negative_Login
    //Description:
    //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
    //Acceptance Criteria
    //Customer email: fake@bluerentalcars.com
    //Customer password: fakepass
    //Error:
    //User with email fake@bluerentalcars.com not found

    @Test
    public void test01() {

        //BlueRentalCar sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //Login buttonuna tıklayalım
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.loginButton.click();


        //Properties dosyasındaki kullanımda olmayan email ve password bilgileri ile
        // login olamadığını test edelim
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("fakeEmail"));
        blueRentalPage.password.sendKeys(ConfigReader.getProperty("fakePassword"), Keys.ENTER);

        ReusableMethods.visibleWait(blueRentalPage.negativeloginVerify,15);
        Assert.assertTrue(blueRentalPage.negativeloginVerify.isDisplayed());

        //sayfayı kapatınız
        Driver.closeDriver();


    }
}