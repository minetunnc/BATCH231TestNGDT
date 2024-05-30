package techproed.tests.day21_pom_excel;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.AllovercommercePage;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Us20practice {
    AllovercommercePage acp = new AllovercommercePage();
    @Test
    public void testCoupon() {
        Driver.getDriver().get("https://allovercommerce.com/");
        acp = new AllovercommercePage();
        acp.signInButton.click();
        acp.emailBox.sendKeys("gmt_2601@hotmail.com");
        acp.passwordBox.sendKeys("Mm123456.", Keys.ENTER);
        acp.signOutButton.click();
        acp.storeManager.click();
        ReusableMethods.click(acp.couponsButton);
        acp.addNewButton.click();


    }
}
