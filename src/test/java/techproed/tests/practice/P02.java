package techproed.tests.practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import techproed.pages.DemoPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.ReusableMethods;

public class P02 {

    //Go to https://demo.automationtesting.in/Register.html
    //fill firstname, secondname, address fields with faker
    // Get the fake email by going to https://www.fakemail.net/
    // go back and fill in the email address field with this email
    // upload a file to the page
    DemoPage demoPage=new DemoPage();
    Faker faker = new Faker();

    @Test(description = "US003 - AC02 registration page should be able to register the user")
    public void registrationTest() {
        //https://demo.automationtesting.in/Register.html adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("demoUrl"));
        ExtentReportUtils.extentTestInfo("https://demo.automationtesting.in/Register.html adresine gidilir");

        // faker ile firstname, secondname, adress alanlarini doldurun
        demoPage.firstName.sendKeys(
                faker.name().firstName(), Keys.TAB,
                faker.name().lastName(), Keys.TAB,
                faker.address().fullAddress()
        );

        // https://www.fakemail.net/ adresine giderek fake maili alin
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("fakeEmailUrl"));
        String fakeEmail = demoPage.fakeEmail.getText();

        // geri dönün ve email adress kısmını bu email ile doldurun
        ReusableMethods.switchToWindow(0);
        demoPage.emailBox.sendKeys(fakeEmail);

        // sayfaya bir dosya yükleyin
        ExtentReportUtils.extentTestInfo("Sayfaya bir dosya yuklenir");
        String path =  System.getProperty("user.home") + "\\Desktop\\logo.png";
        demoPage.chooseFile.sendKeys(path);




    }
}