package techproed.tests.day22_excel_dataprovider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.DataProviderPage;
import techproed.utilities.DataProviderUtils;
import techproed.utilities.Driver;

public class C05_DataProviderTest {


    @Test(dataProvider = "positiveTestData",dataProviderClass = DataProviderUtils.class)
    public void test01(String age) {

        //https://dataprovider.netlify.app/ adresine gidelim
        Driver.getDriver().get("https://dataprovider.netlify.app/");

        //BlackBoxTesting techniques ile otomasyon test yapalim
        DataProviderPage dataProviderPage = new DataProviderPage();
        dataProviderPage.searchBox.sendKeys(age, Keys.TAB, Keys.ENTER);
        Assert.assertTrue(dataProviderPage.positiveVerifyMessage.isDisplayed());
        Driver.closeDriver();

    }
}