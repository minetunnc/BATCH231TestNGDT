package techproed.tests.practice;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.pages.dhtmlPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.util.List;

public class P04 {

    @Test
    public void test01() {

        //http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("dhtmlUrl"));
        //Tüm ülkeleri yazdırınız
        dhtmlPage dhtmlPage = new dhtmlPage();
       List<WebElement> countries = dhtmlPage.countries;
       for (WebElement w : countries){
           System.out.println(w.getText());
       }
        //Ülkeler ile şehirleri eşleştiriniz

    }
}