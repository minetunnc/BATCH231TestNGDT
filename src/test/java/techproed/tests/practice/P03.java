package techproed.tests.practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.ReusableMethods;

public class P03 {

    //Go to https://books-pwakit.appspot.com/
    //search for selenium in searchbox
    //test if the header contains selenium


    @Test(description = "US003 - AC03 user should be able to search")
    public void searchTest() {
        //https://books-pwakit.appspot.com/ adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("booksUrl"));
        ExtentReportUtils.extentTestInfo("https://books-pwakit.appspot.com/ adresine gidilir");

        //searchboxta selenium aratin
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement searchBox = (WebElement) js.executeScript("return document.querySelector(\"body > book-app\").shadowRoot.querySelector(\"#input\")");
        searchBox.sendKeys("selenium", Keys.ENTER);
        ReusableMethods.waitForSecond(2);

        //basligin selenium icerdigini test edin
        ExtentReportUtils.extentTestPass("basligin selenium icerdigi doğrulandi");
        ExtentReportUtils.addScreenShotToReport();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("selenium"));

    }
}