package techproed.tests.day21_pom_excel;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.FileNotFoundException;
import java.time.Duration;

public class C01_PropertiesTest {

    //Go to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    //Log in by locating the UserName, UserPassword, submitButton elements
    //user=Admin
    //userPassword=admin123
    //Test that the Login Test is successful
    //close the page

    @Test
    public void test01() throws InterruptedException, FileNotFoundException {

        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adresine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("openSourceUrl"));

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        OpenSourcePage openSourcePage = new OpenSourcePage();
        openSourcePage.userName.sendKeys(ConfigReader.getProperty("openSourceUserName"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("openSourcePassword"));
        openSourcePage.loginButton.submit();

        //Login Testinin basarili oldugunu test edelim
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(openSourcePage.dashboard));

        Assert.assertTrue(openSourcePage.dashboard.isDisplayed());

        //sayfayi kapatalim
        Thread.sleep(3000);
        Driver.closeDriver();

    }


    @Test
    public void test02() throws InterruptedException, FileNotFoundException {

        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adresine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("openSourceUrl"));

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        OpenSourcePage openSourcePage = new OpenSourcePage();
        openSourcePage.userName.sendKeys(ConfigReader.getProperty("openSourceUserName"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("openSourcePassword"));

        ReusableMethods.screenShotOfWebElement(openSourcePage.loginButton);

        openSourcePage.loginButton.submit();

        //Login Testinin basarili oldugunu test edelim
        ReusableMethods.visibleWait(openSourcePage.dashboard,15);

        ReusableMethods.screenShot("OpenSourceDashBoard");


        Assert.assertTrue(openSourcePage.dashboard.isDisplayed());

        //sayfayi kapatalim
        ReusableMethods.waitForSecond(1);

        Driver.closeDriver();

    }



}