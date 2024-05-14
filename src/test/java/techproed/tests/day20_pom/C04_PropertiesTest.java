package techproed.tests.day20_pom;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.io.FileNotFoundException;

public class C04_PropertiesTest {
    @Test
    public void test01() throws FileNotFoundException {
       String url = ConfigReader.getProperty("amazonUrl");
        System.out.println(url);

        Driver.getDriver().get(url);
        Driver.getDriver().get(ConfigReader.getProperty("techproedUrl"));
    }
}
