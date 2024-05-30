package techproed.tests.day21_pom_excel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.AllovercommercePage;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Us08Pracitce {

    AllovercommercePage acp = new AllovercommercePage();

    @Test
    public void tc01() {
        Driver.getDriver().get("https://allovercommerce.com/");


        acp.searchBox.click();
        acp.searchBox.sendKeys("iphone", Keys.ENTER);
        //Macbook V20.1 isimli ürünün üzerindeki wishlist simgesine tıkla
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(acp.urun).perform();//mouse u macbook webelementi üzerine götürdü
        acp.wishListSymbol.click();

        acp.searchBox.click();
        acp.searchBox.sendKeys("iphone", Keys.ENTER);
        actions.moveToElement(acp.iphone).perform();//mouse u macbook webelementi üzerine götürdü
        acp.wishListSymbol.click();

    }

    @Test
    public void tc02() {
        Driver.getDriver().get("https://allovercommerce.com/");

        acp.searchBox.click();
        acp.searchBox.sendKeys("macbook", Keys.ENTER);
        //Macbook V20.1 isimli ürünün üzerindeki wishlist simgesine tıkla
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(acp.macbook).perform();//mouse u macbook webelementi üzerine götürdü
        acp.wishListSymbol.click();

        acp.searchBox.click();
        acp.searchBox.sendKeys("iphone", Keys.ENTER);
        actions.moveToElement(acp.iphone).perform();//mouse u macbook webelementi üzerine götürdü
        acp.wishListSymbol.click();

    }

    @Test
    public void tc3() {
        Driver.getDriver().get("https://allovercommerce.com/");

        acp.searchBox.click();
        acp.searchBox.sendKeys("macbook", Keys.ENTER);
        //Macbook V20.1 isimli ürünün üzerindeki wishlist simgesine tıkla
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(acp.macbook).perform();//mouse u macbook webelementi üzerine götürdü
        acp.wishListSymbol.click();

        acp.searchBox.click();
        acp.searchBox.sendKeys("iphone", Keys.ENTER);
        actions.moveToElement(acp.iphone).perform();//mouse u macbook webelementi üzerine götürdü
        acp.wishListSymbol.click();

        //Search kutusunun yanındaki Wishlist iconuna tıkla
        acp.wishListIcon.click();

        //Eklenen ürünlerin Wishlist listesinde olduğunu doğrula
        List<String> expectedResult = Arrays.asList("Iphone 15 Pro Max", "Macbook V20.1");
        List<String> list = new ArrayList<>();
        for (WebElement w : acp.products) {
            list.add(w.getText());

        }
        String actualResult = String.join(",", list);

        for (int i = 0; i < expectedResult.size(); i++) {
            Assert.assertTrue(actualResult.contains(expectedResult.get(i)));
        }

    }

    @Test
    public void testName() {
        Driver.getDriver().get("https://allovercommerce.com/");

        AllovercommercePage acp = new AllovercommercePage();
        acp.searchBox.click();
        acp.searchBox.sendKeys("macbook", Keys.ENTER);
        //Macbook V20.1 isimli ürünün üzerindeki wishlist simgesine tıkla
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(acp.macbook).perform();//mouse u macbook webelementi üzerine götürdü
        acp.wishListSymbol.click();

        acp.searchBox.click();
        acp.searchBox.sendKeys("iphone", Keys.ENTER);
        actions.moveToElement(acp.iphone).perform();//mouse u macbook webelementi üzerine götürdü
        acp.wishListSymbol.click();

        //Search kutusunun yanındaki Wishlist iconuna tıkla
        acp.wishListIcon.click();

        //Eklenen ürünlerin Wishlist listesinde olduğunu doğrula
        Assert.assertTrue(acp.iphone.isDisplayed(), "gorunur değil");
        Assert.assertTrue(acp.macbook.isDisplayed(), "gorunur degil");

    }

    @Test
    public void test05() {
        Driver.getDriver().get("https://allovercommerce.com/");

        AllovercommercePage acp = new AllovercommercePage();
        acp.searchBox.click();
        acp.searchBox.sendKeys("macbook", Keys.ENTER);
        //Macbook V20.1 isimli ürünün üzerindeki wishlist simgesine tıkla
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(acp.macbook).perform();//mouse u macbook webelementi üzerine götürdü
        acp.wishListSymbol.click();

        acp.searchBox.click();
        acp.searchBox.sendKeys("iphone", Keys.ENTER);
        actions.moveToElement(acp.iphone).perform();//mouse u macbook webelementi üzerine götürdü
        acp.wishListSymbol.click();

        //Search kutusunun yanındaki Wishlist iconuna tıkla
        acp.wishListIcon.click();

        //Macbook V20.1 isimli ürünün sağındaki QUICK VIEW butonuna tıkla
        ReusableMethods.click(acp.quickViewButton1);

        //Ürünün özelliklerinin görüntülendiğini doğrula

        //Açılan özellikler sayfasını close(x) butonundan kapat
        ReusableMethods.click(acp.closeButton);

        //Iphone 15 Pro Max isimli ürünün  sırasındaki QUICK VIEW butonuna tıkla
        acp.quickViewButton2.click();

        //Ürünün özelliklerinin görüntülendiğini doğrula
        // Ürünün özelliklerinin görüldüğünü doğrula

    }

    @Test
    public void test06() {
        Driver.getDriver().get("https://allovercommerce.com/");

        AllovercommercePage acp = new AllovercommercePage();
        acp.searchBox.click();
        acp.searchBox.sendKeys("macbook", Keys.ENTER);
        //Macbook V20.1 isimli ürünün üzerindeki wishlist simgesine tıkla
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(acp.macbook).perform();//mouse u macbook webelementi üzerine götürdü
        acp.wishListSymbol.click();

        acp.searchBox.click();
        acp.searchBox.sendKeys("iphone", Keys.ENTER);
        actions.moveToElement(acp.iphone).perform();//mouse u macbook webelementi üzerine götürdü
        acp.wishListSymbol.click();

        //Search kutusunun yanındaki Wishlist iconuna tıkla
        acp.wishListIcon.click();

        //Macbook V20.1 isimli ürünün sırasındaki ADD TO CART butonuna tıkla
        ReusableMethods.click(acp.addToCartButton1);

        //Iphone 15 Pro Max isimli ürünün  sırasındaki ADD TO CART   butonuna tıkla
        ReusableMethods.click(acp.addToCartButton2);

        //Cart iconuna tıkla
        acp.cartIcon.click();

        //Açılan sekmeden VIEW CART butonuna tıkla
        ReusableMethods.click(acp.viewCartButton);

        //Ürünlerin sepete eklendiğini doğrula

    }

    @Test
    public void tc07() {
        Driver.getDriver().get("https://allovercommerce.com/");
        Actions actions = new Actions(Driver.getDriver());

        AllovercommercePage acp = new AllovercommercePage();
        acp.searchBox.click();
        acp.searchBox.sendKeys("macbook", Keys.ENTER);
        //Macbook V20.1 isimli ürünün üzerindeki wishlist simgesine tıkla
        actions.moveToElement(acp.macbook).perform();//mouse u macbook webelementi üzerine götürdü
        acp.wishListSymbol.click();
        ReusableMethods.waitForSecond(2);

        //Search kutusunun yanındaki Wishlist iconuna tıkla
        acp.wishListIcon.click();

        //Macbook V20.1 isimli ürünün sırasındaki ADD TO CART butonuna tıkla
        ReusableMethods.click(acp.addToCartButton1);

        //Cart iconuna tıkla
        acp.cartIcon.click();

        //Açılan sekmeden VIEW CART butonuna tıkla
        ReusableMethods.click(acp.viewCartButton);


    }
}







