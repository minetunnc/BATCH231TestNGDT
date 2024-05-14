package techproed.tests.day19_annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C07_SoftAssertionTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {
        //softassertion icin öncelikle bir object olusturmaliyiz
        SoftAssert softAssert= new SoftAssert();

        // 1- amazon anasayfaya gidin
        driver.get("https://amazon.com");
        Thread.sleep(3000);

        // 2- title'in Amazon icerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("Amazoooon"),"title Amazon icermiyor");

        // 3- Arama kutusunun erisilebilir oldugunu test edin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(searchBox.isEnabled(),"arama kutusuna erisilemiyor");

        // 4- arama kutusuna selenium yazip aratin
        searchBox.sendKeys("selenium", Keys.ENTER);

        // 5- arama yapildigini test edin
        WebElement actualResultText= driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        softAssert.assertTrue(actualResultText.isDisplayed());

        Thread.sleep(3000);
        // 6- arama sonucunun selenium icerdigini test edin
        softAssert.assertTrue(actualResultText.getText().contains("seleniuuuuum"),"sonuc yazisi selenium icermiyor");

        softAssert.assertAll();

    }
}