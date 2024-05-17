package techproed.tests.day21_pom_excel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.ZeroPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HW_Pom {
    ZeroPage zeroPage = new ZeroPage();


    @Test
    public void test01() {
        //1."http://zero.webappsecurity.com/" Adresine gidin başlığın Personal içerdiğini test edin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Personal"));
        //2. Sign in butonuna basin
        zeroPage.signin.click();
        ReusableMethods.waitForSecond(2);
        //3. Login kutusuna "username" yazin
        zeroPage.login.sendKeys(ConfigReader.getProperty("login"));
        ReusableMethods.waitForSecond(2);
        //4. Password kutusuna "password" yazin
        zeroPage.password.sendKeys(ConfigReader.getProperty("password"));
        //5. Sign in tusuna basin
        zeroPage.sign.click();
        Driver.getDriver().navigate().back();
        //6. Online banking menusu icinde Pay Bills sayfasina gidin başlığın Zero içerdiğini test edin
        zeroPage.onlinebanking.click();
        zeroPage.paybills.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Zero"));
        //7. "Purchase Foreign Currency" tusuna basin
        zeroPage.foreign.click();
        //8. "Currency" drop down menusunden Eurozone'u secin
        Select select = new Select(zeroPage.currency);
        select.selectByValue("EUR");

        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin

    SoftAssert softAssert = new SoftAssert();
    String selectedOptionText = select.getFirstSelectedOption().getText();
            softAssert.assertEquals(selectedOptionText,"Eurozone (Euro)","Eurozone (Euro) secili degil!");

    //10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu testedin
    // ("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
    //(franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
    //(pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
    //(krone)","New Zealand (dollar)","Sweden (krona)","Singapore
    //(dollar)","Thailand (baht)")
        List<String> expectedList = Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
                "China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
                "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
                "New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)");
        List<String> allOptionsStringList = new ArrayList<>();

       List<WebElement> allOptions = select.getOptions();
       for (WebElement w : allOptions){
           allOptionsStringList.add(w.getText());
       }
softAssert.assertEquals(allOptionsStringList, expectedList,"Liste esit degil!");
       softAssert.assertAll();

       Driver.closeDriver();

}
    }

